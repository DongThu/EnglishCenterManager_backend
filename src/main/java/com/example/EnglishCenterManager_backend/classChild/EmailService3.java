package com.example.EnglishCenterManager_backend.classChild;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;



@Service
public class EmailService3 {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendOpeningNotification(String userEmail, ClassChild timetable) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            
            // Thiết lập thông tin người nhận
            mimeMessageHelper.setTo(userEmail);
            
            // Thiết lập tiêu đề email
            mimeMessageHelper.setSubject("Nhắc nhở lịch học");
            
            // Xây dựng nội dung email
            StringBuilder sb = new StringBuilder();
            sb.append("<h2>Bạn có lịch học sắp tới:</h2>");

            sb.append("<table style='width:100%; border-collapse: collapse;'>");
            sb.append("<tr style='background-color:#f2f2f2;'>");
            sb.append("<th style='border: 1px solid #dddddd; text-align: left; padding: 8px;'>Chương trình</th>");
            sb.append("<th style='border: 1px solid #dddddd; text-align: left; padding: 8px;'>Cấp độ</th>");
            sb.append("<th style='border: 1px solid #dddddd; text-align: left; padding: 8px;'>Khai giảng</th>");
            sb.append("<th style='border: 1px solid #dddddd; text-align: left; padding: 8px;'>Giờ học</th>");
            // sb.append("<th style='border: 1px solid #dddddd; text-align: left; padding: 8px;'>Địa điểm</th>");
            sb.append("</tr>");

            sb.append("<tr>");
            sb.append("<td style='border: 1px solid #dddddd; text-align: left; padding: 8px;'>" + timetable.getCourse().getProgram() + "</td>");
            sb.append("<td style='border: 1px solid #dddddd; text-align: left; padding: 8px;'>" + timetable.getCourse().getLevel() + "</td>");
            sb.append("<td style='border: 1px solid #dddddd; text-align: left; padding: 8px;'>" + timetable.getCourse().getOpenning() + "</td>");
            sb.append("<td style='border: 1px solid #dddddd; text-align: left; padding: 8px;'>" + timetable.getCourse().getSchedule() + "</td>");
            // sb.append("<td style='border: 1px solid #dddddd; text-align: left; padding: 8px;'>Phòng " + timetable.getClassroom() + "</td>");
            sb.append("</tr>");

            sb.append("</table>");
            sb.append("<p>Để biết thêm thông tin về phòng học, vui lòng đăng nhập hệ thống!</p>");

            mimeMessageHelper.setText("<html><body>" + sb.toString() + "</body></html>", true);
            
            javaMailSender.send(mimeMessage);
            System.out.println("Email được gửi thành công!");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Lỗi khi gửi email: " + e.getMessage());
        }
    }
}
