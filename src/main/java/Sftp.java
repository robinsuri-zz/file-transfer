import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Sftp {
  private static Session session;

  public static void main(String[] args) throws Exception {
    JSch.setLogger(new JSCHLogger());
    LocalDateTime startLocal = LocalDateTime.now();
    System.out.println("start = " + startLocal.toString());
    long start = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
    uploadFiles(10);
    LocalDateTime endLocal = LocalDateTime.now();
    System.out.println("end = " + endLocal.toString());
    long end = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
    System.out.println("diff = " + (end - start));
    session.disconnect();

  }

  private static void uploadFiles(int times) throws Exception {
    ChannelSftp channelSftp = getChannel();
    for (int i = 1; i <= times; i++) {
      InputStream inputStream = new FileInputStream("/Users/robin.su/Documents/Checkout/file-transfer-java" +
          "/src/main/resources/upload.pdf");
      Boolean isUploaded = uploadFile(inputStream, channelSftp);
      inputStream.close();
    }

  }

  private static ChannelSftp getChannel() {
    ChannelSftp channelSftp = null;
    try {
      String userName = "robinsu";
      String host = "staging1-sg-1b.aws.zeta.in";
      JSch jsch = new JSch();
      java.util.Properties config = new java.util.Properties();
      config.put("StrictHostKeyChecking", "no");
      jsch.addIdentity("/Users/robin.su/Documents/Checkout/file-transfer-java/src/main/resources/id_rsa");
      session = jsch.getSession(userName, host,22);
      session.setConfig(config);
      session.connect();
      channelSftp = (ChannelSftp) session.openChannel("sftp");
      channelSftp.connect();
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Inside channel");
    }
    return channelSftp;
  }

  private static Boolean uploadFile(InputStream inputStream, ChannelSftp channelSftp) {
    try {
      String fileName = "test" + LocalDateTime.now().toString();
      channelSftp.put(inputStream, "/home/robinsu/sftp/" + fileName);
    } catch (SftpException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  private static void printThreadDetails() {
    String message = String.format("isDaemon = %s isAlive = %s name = %s", Thread.currentThread().isDaemon(),
        Thread.currentThread().isAlive(), Thread.currentThread().getName());
    System.out.println(message);
  }
}