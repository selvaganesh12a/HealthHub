CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS doctors (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    specialization VARCHAR(255) NOT NULL,
    experience INT NOT NULL,
    consultation_fee DOUBLE NOT NULL,
    available_days VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS appointments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    patient_id BIGINT NOT NULL,
    doctor_id BIGINT NOT NULL,
    appointment_date DATE NOT NULL,
    appointment_time TIME NOT NULL,
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (patient_id) REFERENCES users(id),
    FOREIGN KEY (doctor_id) REFERENCES doctors(id),
    UNIQUE KEY unique_booking (doctor_id, appointment_date, appointment_time)
);

-- Initial Data (Only if empty, handled by application logic or manual run)
-- INSERT INTO users (username, password, role) VALUES ('admin', 'admin123', 'ADMIN');
