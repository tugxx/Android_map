<?php
	require "dbCon.php";

	if (isset($_POST['teacher_id'])) {	
		$teacher_id = $_POST['teacher_id'];
		
		$query = "SELECT * FROM class WHERE teacher_id='$teacher_id'";
		$data = mysqli_query($connect, $query);
		
		$listclass= [];
		while ($row = mysqli_fetch_assoc($data)) {
			$listclass[] = new dbclass($row['class_id'], $row['class_name'], $row['teacher_id'], $row['class_time'], $row['total_student']);
			error_log($row['class_name']);
		}

		if(!empty($data)){
			echo json_encode($listclass);
		} else {
			echo "Error";
		}
	}
?>