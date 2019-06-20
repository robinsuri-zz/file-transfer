import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Sftp {
  private static Session session;

  public static void main(String[] args) throws Exception {
    LocalDateTime startLocal = LocalDateTime.now();
    System.out.println("start = " + startLocal.toString());
    long start = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
    uploadFiles(1000);
    LocalDateTime endLocal = LocalDateTime.now();
    System.out.println("end = " + endLocal.toString());
    long end = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
    System.out.println("diff = " + (end - start));
    session.disconnect();

  }

  private static void uploadFiles(int times) throws Exception {
    ChannelSftp channelSftp = getChannel();
    for (int i = 1; i <= times; i++) {
      InputStream inputStream = new FileInputStream("/Users/robin.su/Documents/Checkout/" +
          "largeFile-transfer-java/src/main/resources/upload.pdf");
      BufferedInputStream bis = new BufferedInputStream(inputStream);
      Boolean isUploaded = uploadFile(bis, channelSftp);
      bis.close();
    }

  }

  private static ChannelSftp getChannel() {
    ChannelSftp channelSftp = null;
    try {
      String userName = "cisco_sftp";
      String password = "xwsBjXNo72V2UxI5kOg";
      String host = "10.42.1.192";
      JSch jSch = new JSch();
      java.util.Properties config = new java.util.Properties();
      config.put("StrictHostKeyChecking", "no");
      session = jSch.getSession(userName, host);
      session.setConfig(config);
      session.setPassword(password);
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
      channelSftp.put(inputStream, "/zetakycuat/" + fileName);
    } catch (SftpException e) {
      System.out.println(e);
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