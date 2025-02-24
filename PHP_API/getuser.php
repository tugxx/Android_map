<?php
    require "Constants.php";

    // Create connection
    $conn = new mysqli(DB_HOST, DB_USER, DB_PASSWORD, DB_NAME);
    // error_log("DB_HOST: " . DB_HOST . ", DB_USER: " . DB_USER . ", DB_PASSWORD: " . DB_PASSWORD . ", DB_NAME: " . DB_NAME);

    // Check connection
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }

    // Get username and password from POST request
    $username = isset($_POST['username']) ? $_POST['username'] : '';
    $password = isset($_POST['password']) ? $_POST['password'] : '';
    // error_log("username ".$username);
    // error_log("password ".$password);

    // empy -> exit
    if (empty($username) || empty($password)) {
        echo "Error"; // Or a more specific error message
        exit; // Stop execution
    }

    // Prepare and execute the SQL query (using prepared statements for security)
    $stmt = $conn->prepare("SELECT username, password, i_role, i_student, i_teacher FROM users WHERE username = ?"); // Assuming your table is named "users"
    $stmt->bind_param("s", $username);
    $stmt->execute();
    $result = $stmt->get_result();

    if ($result->num_rows > 0) {
        $row = $result->fetch_assoc();
        $db_username = $row['username'];
        $db_password = $row['password'];


        // Verify the password (you might want to use password_hash/password_verify in a real application)
        if ($password == $db_password) {  //  <-- IMPORTANT: In a real app, use password_verify() here
            // Authentication successful
            $response = array(
                "username" => $row['username'],
                "password" => $row['password'], // In a real app, don't send the password back!
                "i_role" => $row['i_role'],
                "i_student" => $row['i_student'],
                "i_teacher" => $row['i_teacher']
            );
            echo json_encode($response);
        } else {
            echo "Error"; // Incorrect password
        }
    } else {
        echo "Error"; // User not found
    }

    $stmt->close();
    $conn->close();
?>