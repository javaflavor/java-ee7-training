// Check Java version >= 1.8
if (java.lang.System.getProperty("java.specification.version") < "1.8") {
    println("Error: Java 8 is required.")
    exit(1)
}
// Load java 7 compatible global objects.
load("nashorn:mozilla_compat.js")

importPackage(com.sun.tools.attach)
importPackage(javax.management)
importPackage(javax.management.remote)

if (arguments.length != 1) {
    println("Usage: jrunscript jmx_attach_sample.js <pid>")
    exit(1)
}
var pid = arguments[0]

// MBeanサーバコネクションの取得
vm = VirtualMachine.attach(pid)
javahome = java.lang.System.getProperty("java.home")
agent = javahome + "/lib/management-agent.jar"
vm.loadAgent(agent)

prop = vm.getAgentProperties()
addr = prop.getProperty("com.sun.management.jmxremote.localConnectorAddress")
url = new JMXServiceURL(addr)
connector = JMXConnectorFactory.connect(url)
con = connector.getMBeanServerConnection()

// MBean名の準備
objname = new ObjectName('jboss.as:subsystem=datasources,data-source=ExampleDS')

// 属性値の取得
value= con.getAttribute(objname, "enabled")

print("value = "+value)
