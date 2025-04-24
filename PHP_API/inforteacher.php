<?php
	require "dbCon.php";

	if (isset($_POST['teacher_id'])) {
		$teacher_id= $_POST['teacher_id'];

		$query = "Select * from teacher where teacher_id = '$teacher_id'";
		$data = mysqli_query($connect, $query);
		while ($row = mysqli_fetch_assoc($data)) {
			$inforteacher = new inforteacher($row['teacher_id'], $row['teacher_name'], $row['teacher_birth'], $row['teacher_gender'], $row['teacher_mail'],$row['teacher_phone'],$row['teacher_image'], $row['status']);
		}

		if(isset($data)&& isset($inforteacher)){
			echo json_encode($inforteacher);

		} else {
			echo "Error";
		}
	}
?>