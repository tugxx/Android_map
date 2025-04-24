<?php
	require "dbCon.php";

	if(isset($_POST['student_id']))
	{

		$student_id= $_POST['student_id'];

		$query = "Select * from student where student_id = '$student_id'";

		$data = mysqli_query($connect, $query);

		while ($row = mysqli_fetch_assoc($data)) {
			$inforstudent = new inforstudent($row['student_id'], $row['student_name'], $row['student_birth'], $row['student_gender'], $row['student_mail'],$row['student_phone'], $row['student_image'], $row['status']);
		}

		if (isset($data) && isset($inforstudent)) {
			echo json_encode($inforstudent); // Return student info
		} else {
			echo "Error";
		};
	}
?>