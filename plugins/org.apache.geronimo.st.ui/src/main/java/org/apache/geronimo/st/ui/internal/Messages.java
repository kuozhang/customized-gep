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
package org.apache.geronimo.st.ui.internal;


import org.apache.geronimo.st.ui.Activator;
import org.eclipse.osgi.util.NLS;

/**
 * Translated messages.
 *
 * @version $Rev$ $Date$
 */
public class Messages extends NLS {
   
	static {
        NLS.initializeMessages(Activator.PLUGIN_ID + ".internal.Messages", Messages.class);
    }
	
	public static String dbAddNewDriver;
    public static String formServerInfo;
    public static String formHelp;
    
    public static String editorTabSource;

    public static String editorSectionSecurityTitle;
    public static String editorSectionSecurityDescription;
    public static String editorSectionPortsTitle;
    public static String editorSectionPortsDescription;
    public static String editorSectionLogLevelTitle;
    public static String editorSectionLogLevelDescription;
    public static String editorSectionVMArgsTitle;
    public static String editorSectionVMArgsDescription;
    public static String editorSectionStartupTitle;
    public static String editorSectionStartupDescription;

    public static String editorSectionTestEnvTitle;
    public static String editorSectionTestEnvDescription;
    public static String editorSectionNotRedeployJSPFiles;
    public static String editorSectionRunFromWorkspace;
    public static String editorSectionSharedLibrariesInPlace;
    public static String editorSectionSelectClasspathContainers;
    public static String editorSectionPublishAdvancedTitle;
    public static String editorSectionPublishAdvancedDescription;
    public static String notRedeployJSPFilesReminder;
    public static String notRedeployJSPFilesInformation;

    public static String publishingTimeout;
    public static String info;
    public static String debug;
    public static String httpPort;
    public static String rmiPort;
    public static String username;
    public static String password;
    public static String console;
    public static String consoleTooltip;
    public static String supportWebPage;
    public static String supportWebPageTooltip;
    public static String pingDelay;
    public static String pingInterval;
    public static String maxPings;
    public static String pingDelayTooltip;
    public static String pingIntervalTooltip;
    public static String maxPingsTooltip;

    public static String newServerWizardTitle;
    public static String newServerWizardDescription;

    public static String installedJRE;
    public static String installedJREs;
    public static String runtimeDefaultJRE;
    public static String runtimeWizardTitle;
    public static String browse;
    public static String installDir;
    public static String installDirInfo;
    public static String noSuchDir;
    public static String noImageFound;
    public static String cannotInstallAtLocation;
    public static String serverDetected;
    public static String downloadOptions;
    public static String chooseWebContainer;
    public static String gWithTomcat;
    public static String gWithJetty;
    public static String DownloadServerButtonLabel;
    public static String DownloadServerText;
    public static String DownloadServerURL;
    public static String jvmWarning;
    public static String installTitle;
    public static String installMessage;
    public static String tooltipLoc;
    public static String tooltipInstall;
    public static String tooltipJetty;
    public static String tooltipTomcat;

    public static String sourceLocWizTitle;
    public static String sourceLocWizDescription;
    public static String sourceZipFile;
    public static String browseSrcDialog;

    public static String hostName;
    public static String adminId;
    public static String adminPassword;
    public static String specifyPorts;
    public static String portName;
    public static String portValue;

    public static String appGeneralPageTitle;
    public static String appClientGeneralPageTitle;
    public static String connectorOverViewPageTitle;
    public static String deploymentPageTitle;
    public static String namingFormPageTitle;
    public static String securityPageTitle;
    public static String webGeneralPageTitle;
    public static String editorTabGeneral;
    public static String editorTabNaming;
    public static String editorTabSecurity;
    public static String editorTabConnector;
    public static String editorTabDeployment;
    public static String errorCouldNotOpenFile;
    public static String editorTitle;
    public static String editorSectionGeneralTitle;
    public static String editorSectionGeneralDescription;
    public static String editorContextRoot;
    public static String editorWorkDir;
    public static String editorSecurityRealmName;
    public static String editorApplicationName;
    public static String editorCallbackHandler;
    public static String editorDomainName;
    public static String editorRealmName;
    public static String editorSubjectId;
    public static String editorejbqlCompilerFactory;
    public static String editordbSyntaxFactory;
    public static String enforceForeignKeyConstraints;
    public static String editorSectionServerTitle;
    public static String editorSectionServerDescription;
    public static String editorSectionClientTitle;
    public static String editorSectionClientDescription;
    //
    public static String editorSectionSecurityRolesTitle;
    public static String editorSectionSecurityRolesDescription;
    public static String editorSectionSecurityAdvancedTitle;
    public static String editorSectionSecurityAdvancedDescription;
    public static String name;
    public static String description;
    //
    public static String editorSectionDependenciesTitle;
    public static String editorSectionDependenciesDescription;
    public static String editorSectionClientDependenciesTitle;
    public static String editorSectionClientDependenciesDescription;
    //
    public static String editorSectionHiddenClassesTitle;
    public static String editorSectionHiddenClassesDescription;
    public static String editorSectionClientHiddenClassesTitle;
    public static String editorSectionClientHiddenClassesDescription;
    public static String editorSectionNonOverridableTitle;
    public static String editorSectionNonOverridableDescription;
    public static String editorSectionClientNonOverridableTitle;
    public static String editorSectionClientNonOverridableDescription;
    //
    public static String editorSectionAdminObjectTitle;
    public static String editorSectionAdminObjectDescription;
    public static String editorSectionMessageDestTitle;
    public static String editorSectionMessageDestDescription;
    //
    public static String editorSectionModuleTitle;
    public static String editorSectionModuleDescription;
    //
    public static String editorSectionExtModuleTitle;
    public static String editorSectionExtModuleDescription;
    //
    public static String editorSectionImportTitle;
    public static String editorSectionImportDescription;
    //
    public static String editorSectionGBeanTitle;
    public static String editorSectionGBeanDescription;
    public static String className;
    public static String interfaceName;
    public static String GbeanName;
    //
    public static String editorResourceRefDescription;
    public static String editorResourceRefTitle;
    public static String editorResRefTargetNameTitle;
    public static String editorResRefLinkTitle;
    public static String editorResRefNameTitle;
    //
    public static String editorGBeanRefTitle;
    public static String editorGBeanRefDescription;
    public static String editorGBeanRefName;
    public static String editorGBeanRefType;
    public static String editorGBeanRefTargetName;
    public static String editorGBeanRefProxyType;
    //
    //
    public static String editorPersContextRefTitle;
    public static String editorPersContextRefDescription;
    public static String editorPersUnitRefTitle;
    public static String editorPersUnitRefDescription;
    //
    public static String editorServiceRefDescription;
    public static String editorServiceRefTitle;
    public static String editorServiceRefName;
    //
    public static String editorResourceEnvRefDescription;
    public static String editorResourceEnvRefTitle;
    public static String editorResEnvRefMsgDestTitle;
    public static String editorResEnvRefNameTitle;
    //
    public static String editorEjbLocalRefDescription;
    public static String editorEjbLocalRefTitle;
    public static String editorEjbRefTargetName;
    public static String editorEjbRefEjbLink;
    //
    public static String editorEjbRefDescription;
    public static String editorEjbRefTitle;
    public static String editorEjbRelationDescription;
    public static String editorEjbRelationTitle;
    // Buttons
    public static String add;
    public static String remove;
    public static String edit;
    // Wizard/Wizard Pages
    public static String wizardTitle_ManageAccount;
    public static String wizardNewTitle_ResRef;
    public static String wizardEditTitle_ResRef;
    public static String wizardPageTitle_ResRef;
    public static String wizardPageDescription_ResRef;
    //
    public static String wizardNewTitle_AdminObject;
    public static String wizardEditTitle_AdminObject;
    public static String wizardPageTitle_AdminObject;
    public static String wizardPageDescription_AdminObject;
    //
    public static String wizardNewTitle_GBeanRef;
    public static String wizardEditTitle_GBeanRef;
    public static String wizardPageTitle_GBeanRef;
    public static String wizardPageDescription_GBeanRef;
    //
    public static String wizardNewTitle_PersContextRef;
    public static String wizardEditTitle_PersContextRef;
    public static String wizardPageTitle_PersContextRef;
    public static String wizardPageDescription_PersContextRef;
    //
    public static String wizardNewTitle_ServiceRef;
    public static String wizardEditTitle_ServiceRef;
    public static String wizardPageTitle_ServiceRef;
    public static String wizardPageDescription_ServiceRef;
    //
    public static String wizardNewTitle_ResEnvRef;
    public static String wizardEditTitle_ResEnvRef;
    public static String wizardPageTitle_ResEnvRef;
    public static String wizardPageDescription_ResEnvRef;
    //
    public static String wizardNewTitle_EjbRef;
    public static String wizardEditTitle_EjbRef;
    public static String wizardPageTitle_EjbRef;
    public static String wizardPageDescription_EjbRef;
    //
    public static String wizardNewTitle_EjbRelation;
    public static String wizardEditTitle_EjbRelation;
    public static String wizardPageTitle_EjbRelation;
    public static String wizardPageDescription_EjbRelation;
    //
    public static String wizardNewTitle_EjbLocalRef;
    public static String wizardEditTitle_EjbLocalRef;
    public static String wizardPageTitle_EjbLocalRef;
    public static String wizardPageDescription_EjbLocalRef;
    //
    public static String wizardNewTitle_PersUnitRef;
    public static String wizardEditTitle_PersUnitRef;
    public static String wizardPageTitle_PersUnitRef;
    public static String wizardPageDescription_PersUnitRef;
    //
    public static String wizardNewTitle_RoleMapping;
    public static String wizardEditTitle_RoleMapping;
    public static String wizardPageTitle_RoleMapping;
    public static String wizardPageDescription_RoleMapping;
    //
    public static String wizardNewTitle_RunAsSubject;
    public static String wizardEditTitle_RunAsSubject;
    public static String wizardPageTitle_RunAsSubject;
    public static String wizardPageDescription_RunAsSubject;
    //
    public static String wizardNewTitle_ServerCustomAssembly;
    public static String wizardEditTitle_ServerCustomAssembly;
    public static String wizardPageTitle_ServerCustomAssembly;
    public static String wizardPageDescription_ServerCustomAssembly;
    //
    public static String wizardNewTitle_Dependency;
    public static String wizardEditTitle_Dependency;
    public static String wizardPageTitle_Dependency;
    public static String wizardPageDescription_Dependency;
    public static String wizardTabManual_Dependency;
    public static String wizardTabServer_Dependency;
    public static String dependencyGroupLabel;
    
    public static String addUser;
    public static String delUser;
    public static String editUser;
    public static String oldPassword;
    public static String newPassword;
    public static String groupName;
    public static String passwordNotEqual;
    public static String cannotSave;
    public static String cannotRead;

    public static String groupId;
    public static String artifactId;
    public static String version;
    public static String type;
    public static String element;
    public static String customName;
    public static String value;
    public static String messageDestinationName;
    public static String adminModule;
    public static String adminLink;
    public static String contextName;
    public static String unitRefName;
    public static String unitName;
    public static String mtmTableName;
    public static String ejbSourceName;
    public static String cmrFieldName;
    public static String keyColumn;
    public static String foreignKeyColumn;
    //
    public static String wizardNewTitle_Import;
    public static String wizardEditTitle_Import;
    public static String wizardPageTitle_Import;
    public static String wizardPageDescription_Import;
    //
    public static String wizardNewTitle_GBean;
    public static String wizardEditTitle_GBean;
    public static String wizardPageTitle_GBean;
    public static String wizardPageDescription_GBean;
    //
    public static String wizardNewTitle_MessageDest;
    public static String wizardEditTitle_MessageDest;
    public static String wizardPageTitle_MessageDest;
    public static String wizardPageDescription_MessageDest;
    //
    public static String wizardNewTitle_License;
    public static String wizardEditTitle_License;
    public static String wizardPageTitle_License;
    public static String wizardPageDescription_License;
    //
    public static String wizardNewTitle_Prerequisite;
    public static String wizardEditTitle_Prerequisite;
    public static String wizardPageTitle_Prerequisite;
    public static String wizardPageDescription_Prerequisite;
    //
    public static String wizardNewTitle_Module;
    public static String wizardEditTitle_Module;
    public static String wizardPageTitle_Module;
    public static String wizardPageDescription_Module;
    //
    public static String wizardNewTitle_ExtModule;
    public static String wizardEditTitle_ExtModule;
    public static String wizardPageTitle_ExtModule;
    public static String wizardPageDescription_ExtModule;
    //
    public static String wizardNewTitle_SecurityRole;
    public static String wizardEditTitle_SecurityRole;
    public static String wizardPageTitle_SecurityRole;
    public static String wizardPageDescription_SecurityRole;
    
    public static String wizardTitle_SecurityRealm;
    public static String wizardFirstPageTitle_SecurityRealm;
    public static String wizardSecondPageTitle_SecurityRealm;
    public static String wizardFirstPageDescription_SecurityRealm;
    public static String wizardSecondPageDescription_SecurityRealm;
    
    public static String basicSettings;
    public static String realmName;
    public static String realmType;
    public static String digestAlgorithm;
    public static String digestEncoding;
    
    public static String sqlQueries;
    public static String userSelectSQL;
    public static String groupSelectSQL;
    
    public static String dataBasePool;
    public static String useDataBasePool;
    public static String useDataBase;
    public static String dataBasePoolName;
    
    public static String jdbcDriverClass;
    public static String jdbcURL;
    public static String jdbcDriver;
    public static String jdbcUserName;
    public static String jdbcPassword;
    public static String confirmPassword;    
    //

    public static String securityCredentialStore;
    public static String securityDefaultSubject;
    public static String securityDefaultSubjectRealmName;
    public static String securityDefaultSubjectId;
    public static String securityDoasCurrentCaller;
    public static String securityUseContextHandler;
    public static String securityRunAsSubjects;
    public static String securityRunAsSubjectRole;
    public static String securityRunAsSubjectRealm;
    public static String securityRunAsSubjectId;
    public static String securityRefreshRoles;


    public static String wizardNewTitle_DBpool;
    public static String wizardBasicPageTitle_DBPool;
    public static String wizardBasicPageDescription_DBPool;
    public static String wizardAdvancedPageTitle__DBPool;
    public static String wizardAdvancedPageDescription__DBPool;
    public static String wizardConnectionPageTitle__DBPool;
    public static String wizardConnectionPageDescription__DBPool;
    //
    public static String doasCurrentCaller;
    public static String useContextHandler;
    public static String defaultRole;
    

    public static String editorCorrect;
    public static String editorDefault;
    public static String serverNotStarted;
    public static String errorOpenDialog;
    public static String errorOpenWizard;

    public static String gBeanLink;
    public static String moduleId;

    public static String useGBeanLink;
    public static String useGBeanPattern;
    public static String artifactType;
    public static String inverseClassloading;
    public static String supressDefaultEnv;
    public static String sharedLibDepends;

    public static String useUnitName;
    public static String usePattern;
    public static String useResourceLink;
    public static String useUrl;
    public static String useResourcePattern;
    public static String resourceLink;
    public static String url;

    public static String addSharedLib;
    public static String webContainerSection;
    public static String webContainerSectionDescription;
    public static String cmpConnectionSection;
    public static String cmpConnectionSectionDescription;

    public static String moduleType;
    public static String path;
    public static String internalPath;
    public static String externalPath;
    public static String altDD;

    public static String serviceCompletionName;
    public static String protocol;
    public static String credential;
    public static String bindingName;
    public static String uri;

    public static String connector;
    public static String ejb;
    public static String java;
    public static String web;

    public static String plugin;
    public static String pluginActions;
    public static String createCustomAssembly;
    public static String convertAppsToPlugins;

    public static String manageAccount;
    public static String manageAccountDescription;
    public static String isNotLocalHost;

    public static String poolName;
    public static String dbType;
    public static String dbName;
    public static String createDatabase;
    public static String loginTimeout;
    public static String blockingTimeout;
    public static String idleTimeout;
    public static String minPoolSize;
    public static String maxPoolSize;
    public static String transactionType;
    public static String loginGroup;
    public static String driverGroup;
    public static String basicGroup;
    public static String advancedGroup;


    public static String licenseAgreement;
    public static String acceptLicenseAgreement;
    public static String rejectLicenseAgreement;
    public static String confirmLicenseRejection;
    public static String license;
    public static String osiApproved;

    public static String savePageTitle;
    public static String savePageMessage;

    //
    public static String wizardTitle_PluginManager;
    public static String wizardPage0Title_PluginManager;
    public static String wizardPage0Description_PluginManager;
    public static String wizardPage1Title_PluginManager;
    public static String wizardPage1Description_PluginManager;
    public static String wizardPage2Title_PluginManager;
    public static String wizardPage2Description_PluginManager;
    public static String wizardPage3Title_PluginManager;
    public static String wizardPage3Description_PluginManager;
    public static String wizardPage4Title_PluginManager;
    public static String wizardPage4Description_PluginManager;
    public static String wizardPage5Title_PluginManager;
    public static String wizardPage5Description_PluginManager;
    public static String localPluginRepo;
    public static String failedToSave;
    public static String savedSuccess;
    public static String createPlugin;
    public static String installPlugins;
    public static String id;
    public static String downloadRepos;
    public static String category;
    public static String pluginURL;
    public static String author;
    public static String geronimoVersions;
    public static String jvmVersions;
    public static String dependencies;
    public static String obsoletes;
    public static String installable;
    public static String event;
    public static String prerequisites;
	public static String newSecurityRealm;
	public static String editSecurityRealm;
	public static String triggerUpdateServerInfo;
	public static String syncDeployDescAndDeplPlan;
	public static String poolNameInvalidTitle;
	public static String poolNameInvalidDesc;
	public static String poolTypeInvalidTitle;
	public static String poolTypeInvalidDesc;
	public static String dbNameInvalidTitle;
	public static String dbNameInvalidDesc;
	public static String dbDriverInvalidTitle;
	public static String dbDriverInvalidDesc;
	public static String dbLoginError0;
	public static String dbLoginError1;
	public static String dbWizardPwd;
	public static String dbWizardLoginTimeout;
	public static String dbWizardDbName;
	public static String dbWizardCreateDb;
	public static String dbWizardUserName;
	public static String dbWizardConnector;
	public static String dbWizardExternalPath;
	public static String dbWizardGroupId;
	public static String dbWizardArtifactId;
	public static String dbWizardArtifactVersion;
	public static String dbWizardArtifactType;
	public static String dbWizardSpecifyConnectInRepository;
	public static String ejbRelalitionName;
	public static String ejbMTMTableName;
	public static String ejbRelalitionRoleName;
	public static String ejbCmrFiledMapping;
	public static String gbean;
	public static String clazz;
	public static String attribute;
	public static String dependency;
	public static String artifact;
	public static String group;
	public static String module;
	public static String reference;
	public static String geronimoDeploymentPlan;
	public static String configGeronimoDeploymentPlan;
	public static String error;
	public static String waring;
	public static String pattern;
	public static String unit;
	public static String property;
	public static String key;
	public static String userBase;
	public static String userSearchMachting;
	public static String userSearchSubtree;
	public static String roleSearchConfig;
	public static String roleBase;
	public static String roleName;
	public static String roleUserSearchStr;
	public static String userRoleSearchStr;
	public static String roleSearchSubtree;
	public static String propertiesFileRealm;
	public static String sqlRealm;
	public static String ldapRealm;
	public static String propertiesFileRealmDesc;
	public static String fileUri;
	public static String userFileUri;
	public static String groupFileUri;
	public static String digestConfig;
	public static String sqlRealmDesc;
	public static String ldapRealmDesc;
	public static String ldapServerConnection;
	public static String initContextFactory;
	public static String connectionUrl;
	public static String connectUsername;
	public static String conncetPwd;
	public static String connectProtocol;
	public static String authentication;
	public static String ldapRealmSearchConfig;
	public static String editLdapRealmSearch;
	public static String userSearchConfig;
	public static String none;
	public static String simple;
	public static String strong;
	public static String distinguishedName;
	public static String realmPrincipal;
	public static String domainName;
	public static String loginDomainPrincipal;
	public static String principal;
	public static String serviceReference;
	public static String host;
	public static String port;
	public static String portCompletionName;
	public static String editorSectionAdminObjectInstance;
	public static String configPropertySetting;
	public static String wizardDatabasePoolDescription;
	public static String wizardDatabasePoolTitle;
	public static String wizardDatabasePoolConnector;
	public static String wizardDatabasePoolExternalPath;
	public static String wizardDatabasePoolNew;
	public static String wizardDatabasePoolEdit;
	public static String gbeanType;
	
	public static String wizardSecurityRealmTitle;
	public static String wizardSecurityRealmDescription;
	public static String wizardSecurityRealmName;
	public static String wizardLoginModuleClass;
	public static String wizardSecurityRealmNew;
	public static String wizardSecurityRealmEdit;
}




