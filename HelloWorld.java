public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World");
    }
}

        String killCommand = String.format("ps -ef|grep java|grep 'kafka_sink_partitition_test_2019_0730/conf/'|awk '{print $2}'|xargs kill -9",taskName);
        try {
            LOG.info(String.format("starting to execute kill command: %s",killCommand));
            ProcessBuilder pb = new ProcessBuilder(killCommand);
            Process process = pb.start();
            int errCode = process.waitFor();
            LOG.info(String.format("finished kill local driver task: %s  code: %s",taskName,errCode ));
        } catch (Exception e) {
            LOG.warn(String.format("kill local driver task: %s error: ",taskName),e);
        }

java.io.IOException: Cannot run program "ps -ef|grep java|grep 'kafka_sink_partitition_test_2019_0730/conf/'|awk '{print $2}'|xargs kill -9": error=2, No such file or directory


ProcessBuilder pb = new ProcessBuilder("/bin/sh", "-c",killCommand);
