<?php
   require "dbCon.php";

   $teacher_id = $_POST['teacher_id'];
   $query = "SELECT * FROM student_schedule WHERE teacher_id = '$teacher_id' group by s_name";
	$data = mysqli_query($connect, $query);

   $mangSchedule = array();
   while($row = mysqli_fetch_assoc($data)){
      array_push($mangSchedule, new Schedule($row['s_id'],$row['s_name'],$row['s_tstart'],$row['s_tend'],$row['s_daybegin'],$row['s_dayend'],$row['student_id'],$row['s_location'],$row['teacher_id']));
   }

   //4.Chuyen dinh dang cua mang -->Json
   echo json_encode($mangSchedule);
?>
