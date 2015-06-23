package org.apache.geronimo.st.v30.core.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.geronimo.st.v30.core.IModulePostPublisher;
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
 * execute prePublishModule and postPublishModule method from extension point 
 */
public class GeronimoPublishHelper {

    private static IModulePrePublisher[] modulePrePublishers = null;
    private static IModulePostPublisher[] modulePostPublishers = null;

    public static IModulePostPublisher[] getModulePostPublishers() {
        if (modulePostPublishers == null) {
            IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(
                    IModulePostPublisher.ID);

            try {
                List<IModulePostPublisher> publishers = new ArrayList<IModulePostPublisher>();

                for (IConfigurationElement element : elements) {
                    final Object o = element.createExecutableExtension("class");

                    if (o instanceof IModulePostPublisher) {
                        IModulePostPublisher publisher = (IModulePostPublisher) o;
                        publishers.add(publisher);
                    }
                }

                modulePostPublishers = publishers.toArray(new IModulePostPublisher[0]);
            } catch (Exception e) {
                // best effort
            }
        }

        return modulePostPublishers;
    }

    public static IModulePrePublisher[] getModulePrePublishers() {
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

    public static boolean postPublishModule(ServerBehaviourDelegate delegate, int kind, int deltaKind, IModule[] module,
            IModuleResourceDelta[] resourceDelta, IProgressMonitor monitor) {
        boolean retval = true;

        IModulePostPublisher[] postPublishers = getModulePostPublishers();
        if (postPublishers != null && postPublishers.length > 0) {
            IModulePostPublisher postPublisher = postPublishers[0];
            retval = postPublisher.postPublishModule(delegate, kind, deltaKind, module, resourceDelta, monitor);
        }

        return retval;
    }

    public static boolean prePublishModule(ServerBehaviourDelegate delegate, int kind, int deltaKind, IModule[] module,
            IModuleResourceDelta[] resourceDelta, IProgressMonitor monitor) {
        boolean retval = true;

        IModulePrePublisher[] prePublishers = getModulePrePublishers();
        if (prePublishers != null && prePublishers.length > 0) {
            IModulePrePublisher prePublisher = prePublishers[0];
            retval = prePublisher.prePublishModule(delegate, kind, deltaKind, module, resourceDelta, monitor);
        }

        return retval;
    }

}
