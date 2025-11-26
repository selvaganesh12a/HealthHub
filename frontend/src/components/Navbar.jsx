import React, { useContext } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { AuthContext } from '../context/AuthContext';
import './Navbar.css'; // We'll create a specific CSS for Navbar layout

const Navbar = () => {
    const { user, logout } = useContext(AuthContext);
    const navigate = useNavigate();

    const handleLogout = () => {
        logout();
        navigate('/login');
    };

    return (
        <nav className="navbar">
            <div className="container navbar-container">
                <Link to="/" className="navbar-logo">
                    Health Hub
                </Link>
                <div className="navbar-links">
                    {user ? (
                        <>
                            {user.role === 'ADMIN' ? (
                                <>
                                    <Link to="/admin" className="nav-link">Dashboard</Link>
                                </>
                            ) : (
                                <>
                                    <Link to="/dashboard" className="nav-link">My Appointments</Link>
                                    <Link to="/doctors" className="nav-link">Book Appointment</Link>
                                </>
                            )}
                            <span className="nav-user">Hello, {user.username}</span>
                            <button onClick={handleLogout} className="btn btn-primary">Logout</button>
                        </>
                    ) : (
                        <>
                            <Link to="/login" className="nav-link">Login</Link>
                            <Link to="/register" className="nav-link">Register</Link>
                        </>
                    )}
                </div>
            </div>
        </nav>
    );
};

export default Navbar;
