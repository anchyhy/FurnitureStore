package com.anchy.util;

public class SendEmail {
    public SendEmail() {
    }
    /***以后需要两个参数：接收方地址 、 内容***/
    public static void send(String subject, String toaddress,String content)throws Exception {

            String hostName = ReadPropertity.EMAILSMTP;
            String fromAddress = ReadPropertity.EMAILADDRESS;
            String fromAPass = ReadPropertity.EMAILPASS;

            EmailHandle emailHandle = new EmailHandle(hostName);
            emailHandle.setFrom(fromAddress);
            emailHandle.setNeedAuth(true);
            emailHandle.setSubject(subject);
            emailHandle.setBody(content);
            emailHandle.setTo(toaddress);
            emailHandle.setFrom(fromAddress);
            emailHandle.addFileAffix("/Users/apple/Documents/说明.txt");// 附件文件路径
            emailHandle.setNamePass(fromAddress, fromAPass);
            emailHandle.sendEmail();
    }
}

