
<?php
   require "dbCon.php";

   $student_id = $_POST['student_id'];
   $query = "SELECT * FROM student_schedule WHERE student_id = '$student_id'";

	$data = mysqli_query($connect, $query);

   //2.Tao mang 
   $mangSchedule = array();

   //3. Them phan tu vao mang
   while($row = mysqli_fetch_assoc($data)){
      array_push($mangSchedule, new Schedule($row['s_id'],$row['s_name'],$row['s_tstart'],$row['s_tend'],$row['s_daybegin'],$row['s_dayend'],$row['student_id'],$row['s_location'],$row['teacher_id']));
   }

   //4.Chuyen dinh dang cua mang -->Json
   echo json_encode($mangSchedule);
?>
