// package com.example.EnglishCenterManager_backend.timetable;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.mail.javamail.MimeMessageHelper;
// import org.springframework.stereotype.Service;

// import jakarta.mail.MessagingException;
// import jakarta.mail.internet.MimeMessage;



// @Service
// public class EmailService2 {

//     @Autowired
//     private JavaMailSender javaMailSender;

//     public void sendOpeningNotification(String teacherEmail, Timetable timetable) {
//         try {
//             MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//             MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

//             mimeMessageHelper.setTo(teacherEmail);
//             mimeMessageHelper.setSubject("Thông báo khai giảng");

//             // Xây dựng nội dung email
//             String content = "Thông báo khai giảng:\n\n" +
//                     "Chương trình: " + timetable.getCourse().getProgram() + "\n" +
//                     "Ngày khai giảng: " + timetable.getOpenning() + "\n" +
//                     "Giáo viên: " + timetable.getTeacher().getFullName() + "\n" +
//                     "Phòng học: " + timetable.getClassroom() + "\n";

//                     mimeMessageHelper.setText(content);

//                     javaMailSender.send(mimeMessage);
//                     System.out.println("Email thông báo khai giảng đã được gửi thành công!"); // In ra console
//                 } catch (MessagingException e) {
//                     System.out.println("Lỗi khi gửi email: " + e.getMessage()); // In ra console nếu có lỗi
//                 }
//     }
// }

