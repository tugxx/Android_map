<?php
	require "dbCon.php";
	if(isset($_POST['class_id']) && isset($_POST['student_id']) )
	{	
	$class_id = $_POST['class_id'];
    $student_id = $_POST['student_id'];

	$query = "SELECT attendance_time FROM attendance WHERE class_id = '$class_id' AND student_id = '$student_id'";
	$data = mysqli_query($connect, $query);
	$listclass= new ArrayObject();
	while ($row = mysqli_fetch_assoc($data)) {
	$class = new dbtime_present_student($row['attendance_time']);
	$listclass [] = $class;
	}
	if(empty($class)){
		echo "Error";
	} else{
		foreach( $listclass as $key => $value ){
			$obj_json[] = $value;
		}
		echo json_encode($obj_json);
	};
	}
?>