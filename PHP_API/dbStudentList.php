<?php
   require "dbCon.php";

   $student_id = $_POST['student_id'];
   $query = "SELECT * from student WHERE student.student_bclass = (select student_bclass from student WHERE student.student_id = '$student_id')";

	$data = mysqli_query($connect, $query);

   //2.Tao mang 
   $mangSV = array();

   //3. Them phan tu vao mang
   while($row = mysqli_fetch_assoc($data)){
      array_push($mangSV, new Student($row['student_id'],$row['student_name'],$row['student_birth'],$row['student_gender'],$row['student_mail'],$row['student_phone'],$row['student_image'],$row['status']));
   }

   // error_log(print_r($mangSV, true));
   
   //4.Chuyen dinh dang cua mang -->Json
   echo json_encode($mangSV);
?>