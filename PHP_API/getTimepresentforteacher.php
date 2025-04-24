<?php
	require "dbCon.php";
	if (isset($_POST['class_id']) && isset($_POST['date_time'])) {	
		$class_id = $_POST['class_id'];
    	$date_time = $_POST['date_time'];

		$query = "SELECT a.student_id, s.student_name, a.attendance_time FROM attendance a INNER JOIN student s on a.student_id = s.student_id WHERE class_id = '$class_id' and attendance_time LIKE '$date_time%'";
		$data = mysqli_query($connect, $query);

		$listclass= new ArrayObject();
		while ($row = mysqli_fetch_assoc($data)) {
			$class = new dbtime_present_teacher($row['student_id'],$row['student_name'],$row['attendance_time']);
			$listclass [] = $class;
		}

		if (!empty($class)) {
			foreach( $listclass as $key => $value ){
				$obj_json[] = $value;
			}
			echo json_encode($obj_json);
		} else {
			echo "Error";
		};
	}
?>