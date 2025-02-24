<?php
    require "dbCon.php";

	$student_id= $_POST['student_id'];
	

	if(isset($_POST['student_id']) && isset($_POST['student_name']) && isset($_POST['student_birth']) && isset($_POST['student_gender']) && isset($_POST['student_mail']) && isset($_POST['student_phone'])&& isset($_POST['student_image']))
	{	
		$student_id= $_POST['student_id'];
		$student_name = $_POST['student_name'];
		$student_birth = $_POST['student_birth'];
		$student_gender = $_POST['student_gender'];
		$student_mail = $_POST['student_mail'];
		$student_phone = $_POST['student_phone'];
		$student_image = $_POST['student_image'];

		$gethinh = "SELECT student_image FROM student WHERE student_id = '$student_id'";
		$data1 = mysqli_query($connect, $gethinh);
		while ($row = mysqli_fetch_assoc($data1))
		{
			$hinhcu = $row['student_image'];
		}
		$hinhcudacat = substr($hinhcu, 59);
		unlink($hinhcudacat);
		
		$query = "UPDATE student sv SET sv.student_name = '$student_name', sv.student_birth = '$student_birth', sv.student_gender = '$student_gender', sv.student_mail = '$student_mail', sv.student_phone = '$student_phone', sv.student_image = '$student_image' WHERE sv.student_id = '$student_id'";
		$data = mysqli_query($connect, $query);
		echo "Done";
	};
?>