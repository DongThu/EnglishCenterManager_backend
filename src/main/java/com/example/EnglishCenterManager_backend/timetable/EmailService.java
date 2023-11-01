package com.example.EnglishCenterManager_backend.timetable;

import java.util.List;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;



// @ComponentScan(basePackages = "com.example.EnglishCenterManager_backend")
@Service
public class EmailService {

    // @Value("${spring.mail.username}")
    // private String fromEmail;

    @Autowired
    private JavaMailSender javaMailSender;
    public void sendTimetableEmailToTeacher(String teacherEmail, List<Timetable> timetables) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            
            // Thiết lập thông tin người nhận
            mimeMessageHelper.setTo(teacherEmail);
            
            // Thiết lập tiêu đề email
            mimeMessageHelper.setSubject("Thời khóa biểu");
            
            // Xây dựng nội dung email
            StringBuilder sb = new StringBuilder();
            sb.append("Thông tin thời khóa biểu:\n\n");
            for (Timetable timetable : timetables) {
                sb.append("Chương trình: " + timetable.getCourse().getProgram() + "\n");
                sb.append("Khai giảng: " + timetable.getCourse().getOpenning() + "\n");
                sb.append("Giờ học: " + timetable.getCourse().getSchedule() + "\n");
                sb.append("Địa điểm: Phòng " + timetable.getClassroom() + "\n\n");

            }
            mimeMessageHelper.setText(sb.toString());
            
            javaMailSender.send(mimeMessage);
            System.out.println("Email được gửi thành công!");
        } catch (MessagingException e) {
            System.out.println("Lỗi khi gửi email: " + e.getMessage());
        }
    }
}
