/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.geronimo.st.v30.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.apache.geronimo.st.core.ServerIdentifier;
import org.apache.geronimo.st.v30.ui.internal.Trace;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.IServerListener;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 *
 * @version $Rev$ $Date$
 */
public class Activator extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "org.apache.geronimo.st.v30.ui";
    public static boolean console;
    public static boolean logUi;
    public static boolean logActions;
    public static boolean logCommands;
    public static boolean logInternal;
    public static boolean logWizards;
    public static boolean logEditors;
    public static boolean logPages;
    public static boolean logSections;
    public static boolean logBlueprint;
    public static boolean logHandlers;

    public static boolean traceUi;
    public static boolean traceActions;
    public static boolean traceCommands;
    public static boolean traceInternal;
    public static boolean traceWizards;
    public static boolean traceEditors;
    public static boolean tracePages;
    public static boolean traceSections;
    public static boolean traceBlueprint;
    public static boolean traceHandlers;
    
    private static Map<ServerIdentifier, List<IServerListener>> serverListenersMap = new HashMap<ServerIdentifier, List<IServerListener>>();
    
    static {
        try {
            console = Boolean.parseBoolean(Platform.getDebugOption(PLUGIN_ID + "/console"));

            logUi = Boolean.parseBoolean(Platform.getDebugOption(PLUGIN_ID + "/log/ui"));
            logActions = Boolean.parseBoolean(Platform.getDebugOption(PLUGIN_ID + "/log/actions"));
            logCommands = Boolean.parseBoolean(Platform.getDebugOption(PLUGIN_ID + "/log/commands"));
            logInternal = Boolean.parseBoolean(Platform.getDebugOption(PLUGIN_ID + "/log/internal"));
            logWizards = Boolean.parseBoolean(Platform.getDebugOption(PLUGIN_ID + "/log/wizards"));
            logEditors = Boolean.parseBoolean(Platform.getDebugOption(PLUGIN_ID + "/log/editors"));
            logPages = Boolean.parseBoolean(Platform.getDebugOption(PLUGIN_ID + "/log/pages"));
            logSections = Boolean.parseBoolean(Platform.getDebugOption(PLUGIN_ID + "/log/sections"));
            logBlueprint = Boolean.parseBoolean(Platform.getDebugOption(PLUGIN_ID + "/log/blueprint"));
            logHandlers = Boolean.parseBoolean(Platform.getDebugOption(PLUGIN_ID + "/log/handlers"));

            traceUi = Boolean.parseBoolean(Platform.getDebugOption(PLUGIN_ID + "/trace/ui"));
            traceActions = Boolean.parseBoolean(Platform.getDebugOption(PLUGIN_ID + "/trace/actions"));
            traceCommands = Boolean.parseBoolean(Platform.getDebugOption(PLUGIN_ID + "/trace/commands"));
            traceInternal = Boolean.parseBoolean(Platform.getDebugOption(PLUGIN_ID + "/trace/internal"));
            traceWizards = Boolean.parseBoolean(Platform.getDebugOption(PLUGIN_ID + "/trace/wizards"));
            traceEditors = Boolean.parseBoolean(Platform.getDebugOption(PLUGIN_ID + "/trace/editors"));
            tracePages = Boolean.parseBoolean(Platform.getDebugOption(PLUGIN_ID + "/trace/pages"));
            traceSections = Boolean.parseBoolean(Platform.getDebugOption(PLUGIN_ID + "/trace/sections"));
            traceBlueprint = Boolean.parseBoolean(Platform.getDebugOption(PLUGIN_ID + "/trace/blueprint"));
            traceHandlers = Boolean.parseBoolean(Platform.getDebugOption(PLUGIN_ID + "/trace/handlers"));
        } catch (NumberFormatException e) {
            Trace.trace(Trace.ERROR, e.getMessage(), true);
        } catch (NullPointerException e) {
            Trace.trace(Trace.ERROR, e.getMessage(), true);
        }
    }

    // The shared instance
    private static Activator plugin;

    private static String iconLocation;

    @SuppressWarnings("rawtypes")
    private Map imageDescriptors = new HashMap();

    public static final String ICONS_DIRECTORY = "icons/";
    public static final String IMG_WIZ_GERONIMO = "gServer";
    public static final String IMG_PORT = "port";

    /**
     * The constructor
     */
    public Activator() {
        plugin = this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    public void start(BundleContext context) throws Exception {
        super.start(context);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
        clearServerListeners();
    }
    
    private void clearServerListeners() {
        Iterator<Map.Entry<ServerIdentifier, List<IServerListener>>> iter = serverListenersMap.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry<ServerIdentifier, List<IServerListener>> entry = iter.next();
            IServer server = entry.getKey().getServer();
            List<IServerListener> listeners = entry.getValue();
            for(IServerListener ls : listeners) {
                server.removeServerListener(ls);
            }
        }
    }
    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static Activator getDefault() {
        return plugin;
    }

    /**
     * Returns an image descriptor for the image file at the given plug-in
     * relative path.
     * 
     * @param path
     *            the path
     * @return the image descriptor
     */
    public static ImageDescriptor getImageDescriptor(String path) {
        return AbstractUIPlugin.imageDescriptorFromPlugin("org.apache.geronimo.st.v30.ui", path);
    }

    public static String getIconLocation() {
        if (iconLocation == null) {
            try {
                iconLocation = FileLocator.resolve(plugin.getBundle().getEntry("/")).getPath()
                        + ICONS_DIRECTORY;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return iconLocation;
    }
    

    /**
     * Return the image with the given key from the image registry.
     * 
     * @param key
     *            java.lang.String
     * @return org.eclipse.jface.parts.IImage
     */
    public static Image getImage(String key) {
        return plugin.getImageRegistry().get(key);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#initializeImageRegistry(org.eclipse.jface.resource.ImageRegistry)
     */
    protected void initializeImageRegistry(ImageRegistry reg) {
        registerImage(reg, IMG_WIZ_GERONIMO, "g_server.gif");
        registerImage(reg, IMG_PORT, "obj16/port.gif");
    }

    @SuppressWarnings("unchecked")
    private void registerImage(ImageRegistry registry, String key,
            String partialURL) {

        URL iconsURL = plugin.getBundle().getEntry(ICONS_DIRECTORY);

        try { 
            ImageDescriptor id = ImageDescriptor.createFromURL(new URL(iconsURL, partialURL));
            registry.put(key, id);
            imageDescriptors.put(key, id);
        } catch (Exception e) {
            Trace.trace(Trace.WARNING, "Error registering image", e, Activator.logUi);
        }
    }
    
    public static void addServerListener(ServerIdentifier serverId, IServerListener ls) {
        List<IServerListener> listeners = serverListenersMap.get(serverId);
        if(listeners == null) {
            listeners = new ArrayList<IServerListener>();
            serverListenersMap.put(serverId, listeners);
        }
        serverId.getServer().addServerListener(ls);
        listeners.add(ls);
    }
}
