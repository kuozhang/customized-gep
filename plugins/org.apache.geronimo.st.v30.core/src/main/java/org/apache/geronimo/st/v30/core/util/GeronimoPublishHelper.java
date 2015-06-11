package org.apache.geronimo.st.v30.core.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.geronimo.st.v30.core.IModulePrePublisher;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.model.IModuleResourceDelta;
import org.eclipse.wst.server.core.model.ServerBehaviourDelegate;

/**
 * @author Kuo Zhang
 * 
 * execute prePublishModule method from extension point 
 */
public class GeronimoPublishHelper {

    private static IModulePrePublisher[] modulePrePublishers = null;

    public static boolean prePublishModule(ServerBehaviourDelegate delegate, int kind, int deltaKind, IModule[] module,
            IModuleResourceDelta[] resourceDelta, IProgressMonitor monitor) {
        boolean retval = true;

        IModulePrePublisher[] modulePrePublishers = getModulePublishers();
        if (modulePrePublishers != null && modulePrePublishers.length > 0) {
            IModulePrePublisher prePublisher = modulePrePublishers[0];
            retval = prePublisher.prePublishModule(delegate, kind, deltaKind, module, resourceDelta, monitor);
        }

        return retval;
    }

    public static IModulePrePublisher[] getModulePublishers() {
        if (modulePrePublishers == null) {
            IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(
                    IModulePrePublisher.ID);

            try {
                List<IModulePrePublisher> publishers = new ArrayList<IModulePrePublisher>();

                for (IConfigurationElement element : elements) {
                    final Object o = element.createExecutableExtension("class");

                    if (o instanceof IModulePrePublisher) {
                        IModulePrePublisher publisher = (IModulePrePublisher) o;
                        publishers.add(publisher);
                    }
                }

                modulePrePublishers = publishers.toArray(new IModulePrePublisher[0]);
            } catch (Exception e) {
                // best effort
            }
        }

        return modulePrePublishers;
    }

}
