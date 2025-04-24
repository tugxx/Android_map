<?php
	require "dbCon.php";
	$teacher_id = $_POST['teacher_id'];
   $query = "SELECT * from class  WHERE teacher_id='$teacher_id'";
	$data = mysqli_query($connect, $query);

   $mangSV = array();
   while($row = mysqli_fetch_assoc($data)){
      array_push($mangSV, new classS($row['class_id'],$row['class_name'],$row['total_student']));
      // error_log($row['total_student']);
   }

   //4.Chuyen dinh dang cua mang -->Json
   echo json_encode($mangSV);
?>