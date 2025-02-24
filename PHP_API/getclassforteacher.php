<?php
	require "dbCon.php";
	if(isset($_POST['teacher_id']))
	{	
	$teacher_id = $_POST['teacher_id'];
	$query = "SELECT * FROM class WHERE teacher_id='$teacher_id'";
	$data = mysqli_query($connect, $query);
	$listclass= new ArrayObject();
	while ($row = mysqli_fetch_assoc($data)) {
	$class = new dbclass($row['class_id'], $row['class_name'], $row['teacher_id'], $row['class_time'] ,$row['totalStudent']);
	$listclass [] = $class;
	}
	if(!empty($data)){
		foreach( $listclass as $key => $value ){
			$obj_json[] = $value;
		}
		echo json_encode($obj_json);
	}else{
		echo "Error";
	};
	}
?>