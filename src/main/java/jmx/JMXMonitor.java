package jmx;

import javax.management.*;
import java.lang.management.ManagementFactory;


public class JMXMonitor {

    public static void configure(HitsPercentage hitsPercentage, PointStatistics pointStatisticsMBean) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName HitsPercentageMBeanName = new ObjectName("jmx:type=HitsPercentage");
        mBeanServer.registerMBean(hitsPercentage, HitsPercentageMBeanName);
        ObjectName PointStatisticsMBeanName = new ObjectName("jmx:type=PointStatistics");
        mBeanServer.registerMBean(pointStatisticsMBean, PointStatisticsMBeanName);

        }
}