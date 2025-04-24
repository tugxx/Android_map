<?php
	require "dbCon.php";

	$class_id = $_POST['class_id'];
   $query = "Select *
             from student s
             where s.student_id in (Select student_id
                                    from class c
                                    join student_class sc 
                                    on c.class_id = sc.class_id
                                    where c.class_id = '$class_id')";
   $data = mysqli_query($connect, $query);

   //2.Tao mang 
   $mangSV = array();

    //3. Them phan tu vao mang
   while($row = mysqli_fetch_assoc($data)){
      // error_log($row['student_name']);
      array_push($mangSV, new Student($row['student_id'],$row['student_name'],$row['student_birth'],$row['student_gender'],$row['student_mail'],$row['student_phone'],$row['student_image'],$row['status']));
   }

   echo json_encode($mangSV);
?>