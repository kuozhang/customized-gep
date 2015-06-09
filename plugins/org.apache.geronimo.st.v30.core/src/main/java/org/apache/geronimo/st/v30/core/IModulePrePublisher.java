package org.apache.geronimo.st.v30.core;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.model.IModuleResourceDelta;
import org.eclipse.wst.server.core.model.ServerBehaviourDelegate;

/**
 * @author Kuo Zhang
 *
 */
public interface IModulePrePublisher {

    public static final String ID = "org.apache.geronimo.st.v30.core.modulePrePublisher";

    public boolean prePublishModule(ServerBehaviourDelegate delegate, int kind, int deltaKind, IModule[] moduleTree,
            IModuleResourceDelta[] delta, IProgressMonitor monitor);

}
