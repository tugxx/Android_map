<?php
    require "dbCon.php";

    // Check if required parameters are set
    if (isset($_POST['username']) && isset($_POST['newPassword'])) {
        $username = $_POST['username'];
        $password = $_POST['newPassword'];

        // Lấy password
        $query = "SELECT password
                 FROM users
                 WHERE username = '$username'";
        $result = mysqli_query($connect, $query);
        $row = mysqli_fetch_assoc($result);
        if (!$row) {
            echo json_encode([
                'status' => 'error',
                'message' => 'Username not found'
            ]);
            exit;
        }

        $oldpass = $row['password'];

        $query = "UPDATE users 
                  SET password = '$password',
                      oldpass = '$oldpass'
                  WHERE username = '$username'";
        $result = mysqli_query($connect, $query);

        if ($result) {
            if (mysqli_affected_rows($connect) > 0) {
                echo "Done";
            } else {
                echo json_encode([
                'status' => 'error',
                'message' => 'Username not found or no changes made'
                ]);
            }
        }

        // Close connectection
        mysqli_close($connect);
    }
?>