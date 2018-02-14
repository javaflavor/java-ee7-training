// Check Java version >= 1.8
if (java.lang.System.getProperty("java.specification.version") < "1.8") {
    println("Error: Java 8 is required.")
    exit(1)
}
// Load java 7 compatible global objects.
load("nashorn:mozilla_compat.js")

importPackage(javax.management)
importPackage(javax.management.remote)

// MBeanサーバコネクションの取得
url = new JMXServiceURL("service:jmx:remote+http://localhost:9990")
cls = new java.lang.String().getClass()
cred = java.lang.reflect.Array.newInstance(cls, 2)
cred[0] = 'admin'
cred[1] = 'welcome1!'
env = new java.util.HashMap()
env.put("jmx.remote.credentials", cred)
connector = JMXConnectorFactory.connect(url, env)
con = connector.getMBeanServerConnection()

// MBean名の準備
objname = new ObjectName('jboss.as:subsystem=datasources,data-source=ExampleDS')

// 属性値の取得
value= con.getAttribute(objname, "enabled")

print("value = "+value)
