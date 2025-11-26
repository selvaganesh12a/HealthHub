import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import { AuthProvider } from './context/AuthContext';
import Navbar from './components/Navbar';
import Login from './pages/Login';
import Register from './pages/Register';
import PatientDashboard from './pages/PatientDashboard';
import AdminDashboard from './pages/AdminDashboard';
import DoctorList from './pages/DoctorList';

function App() {
    return (
        <AuthProvider>
            <Router>
                <Navbar />
                <Routes>
                    <Route path="/login" element={<Login />} />
                    <Route path="/register" element={<Register />} />
                    <Route path="/dashboard" element={<PatientDashboard />} />
                    <Route path="/admin" element={<AdminDashboard />} />
                    <Route path="/doctors" element={<DoctorList />} />
                    <Route path="/" element={<Navigate to="/login" />} />
                </Routes>
            </Router>
        </AuthProvider>
    );
}

export default App;
