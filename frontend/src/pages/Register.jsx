import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import api from '../services/api';

const Register = () => {
    const [formData, setFormData] = useState({
        username: '',
        password: '',
        role: 'PATIENT', // Default role
    });
    const [error, setError] = useState('');
    const navigate = useNavigate();

    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        setError('');
        try {
            await api.post('/users/register', formData);
            navigate('/login');
        } catch (err) {
            setError(err.response?.data?.error || 'Registration failed');
        }
    };

    return (
        <div className="container">
            <div className="card" style={{ maxWidth: '400px', margin: '2rem auto' }}>
                <h2 style={{ textAlign: 'center', marginBottom: '1.5rem' }}>Register</h2>
                {error && <div className="error-msg" style={{ marginBottom: '1rem' }}>{error}</div>}
                <form onSubmit={handleSubmit}>
                    <div className="form-group">
                        <label className="form-label">Username</label>
                        <input
                            type="text"
                            name="username"
                            className="form-input"
                            value={formData.username}
                            onChange={handleChange}
                            required
                        />
                    </div>
                    <div className="form-group">
                        <label className="form-label">Password</label>
                        <input
                            type="password"
                            name="password"
                            className="form-input"
                            value={formData.password}
                            onChange={handleChange}
                            required
                        />
                    </div>
                    <div className="form-group">
                        <label className="form-label">Role</label>
                        <select
                            name="role"
                            className="form-input"
                            value={formData.role}
                            onChange={handleChange}
                        >
                            <option value="PATIENT">Patient</option>
                            <option value="ADMIN">Admin</option>
                        </select>
                    </div>
                    <button type="submit" className="btn btn-primary" style={{ width: '100%' }}>
                        Register
                    </button>
                </form>
            </div>
        </div>
    );
};

export default Register;
