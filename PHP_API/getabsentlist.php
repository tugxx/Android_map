<?php
	require "dbCon.php";
	if(isset($_POST['class_id']) && isset($_POST['date_time'])) {	
    	$class_id = $_POST['class_id'];
    	$date_time = $_POST['date_time'];

    	// Get student_id in class
		$query1 = "SELECT a.student_id, a.student_name FROM student a INNER JOIN student_class s on a.student_id = s.student_id WHERE s.class_id = '$class_id'";
		$data1 = mysqli_query($connect, $query1);
    	$array_student = new ArrayObject();
    	while ($row = mysqli_fetch_assoc($data1)) {
        	$student = new dbstudent_absent($row['student_id'], $row['student_name']);
        	$array_student [] = $student;
    	}

    	//Get data comepare
    	$query = "SELECT a.student_id, s.student_name, a.attendance_time FROM attendance a INNER JOIN student s on a.student_id = s.student_id WHERE class_id = '$class_id' and attendance_time LIKE '$date_time%'";
		$data = mysqli_query($connect, $query);

		$listabsent= new ArrayObject();
		while ($row = mysqli_fetch_assoc($data)) {
			$absent = new dbtime_absent_teacher($row['student_id'],$row['student_name'],$row['attendance_time']);
			$listabsent [] = $absent;
		}
		$cout_student =count($array_student);
    	
    	//Compare
    	for ($i = 0; $i < count($array_student); $i++){
        	for ($j = 0; $j < count($listabsent); $j++){
            	if ($listabsent[$j]->getStudentid() == $array_student[$i]->getStudentid())
            	$index [] = $i;
        	}
    	}

    	for ($f = 0; $f < count($index); $f++){
    		$array_student->offsetUnset($f);
    	}
	
		//echo data API
		if(count($listabsent) != $cout_student ){
			foreach( $array_student as $key => $value ){
				$obj_json[] = $value;
			}
			echo json_encode($obj_json);
		} else {
			echo "Error";
		};
	}
?>