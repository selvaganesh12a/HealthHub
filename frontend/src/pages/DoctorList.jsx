import React, { useState, useEffect, useContext } from 'react';
import api from '../services/api';
import { AuthContext } from '../context/AuthContext';
import { useNavigate } from 'react-router-dom';

const DoctorList = () => {
    const [doctors, setDoctors] = useState([]);
    const [selectedDoctor, setSelectedDoctor] = useState(null);
    const [bookingData, setBookingData] = useState({ date: '', time: '' });
    const [message, setMessage] = useState('');
    const { user } = useContext(AuthContext);
    const navigate = useNavigate();

    useEffect(() => {
        fetchDoctors();
    }, []);

    const fetchDoctors = async () => {
        try {
            const response = await api.get('/doctors');
            setDoctors(response.data);
        } catch (err) {
            console.error('Error fetching doctors:', err);
        }
    };

    const handleBookClick = (doctor) => {
        setSelectedDoctor(doctor);
        setMessage('');
    };

    const handleBookingSubmit = async (e) => {
        e.preventDefault();
        try {
            await api.post('/appointments', {
                patient: { id: user.id },
                doctor: { id: selectedDoctor.id },
                appointmentDate: bookingData.date,
                appointmentTime: bookingData.time + ':00', // Append seconds for LocalTime
            });
            setMessage('Appointment booked successfully!');
            setSelectedDoctor(null);
            setBookingData({ date: '', time: '' });
            setTimeout(() => navigate('/dashboard'), 2000);
        } catch (err) {
            setMessage(err.response?.data?.error || 'Booking failed');
        }
    };

    return (
        <div className="container">
            <h2 style={{ marginBottom: '1.5rem' }}>Available Doctors</h2>
            {message && <div className={`card ${message.includes('failed') ? 'error-msg' : ''}`} style={{ marginBottom: '1rem', padding: '1rem', backgroundColor: message.includes('failed') ? '#fee2e2' : '#d1fae5', color: message.includes('failed') ? '#b91c1c' : '#065f46' }}>{message}</div>}

            <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(300px, 1fr))', gap: '1.5rem' }}>
                {doctors.map((doctor) => (
                    <div key={doctor.id} className="card">
                        <h3>{doctor.name}</h3>
                        <p style={{ color: '#6b7280' }}>{doctor.specialization}</p>
                        <div style={{ marginTop: '1rem' }}>
                            <p><strong>Experience:</strong> {doctor.experience} years</p>
                            <p><strong>Fee:</strong> ${doctor.consultationFee}</p>
                            <p><strong>Available:</strong> {doctor.availableDays}</p>
                        </div>
                        <button
                            className="btn btn-primary"
                            style={{ marginTop: '1rem', width: '100%' }}
                            onClick={() => handleBookClick(doctor)}
                        >
                            Book Appointment
                        </button>
                    </div>
                ))}
            </div>

            {selectedDoctor && (
                <div style={{
                    position: 'fixed', top: 0, left: 0, right: 0, bottom: 0,
                    backgroundColor: 'rgba(0,0,0,0.5)', display: 'flex', alignItems: 'center', justifyContent: 'center'
                }}>
                    <div className="card" style={{ width: '400px', maxWidth: '90%' }}>
                        <h3>Book with {selectedDoctor.name}</h3>
                        <form onSubmit={handleBookingSubmit} style={{ marginTop: '1rem' }}>
                            <div className="form-group">
                                <label className="form-label">Date</label>
                                <input
                                    type="date"
                                    className="form-input"
                                    value={bookingData.date}
                                    onChange={(e) => setBookingData({ ...bookingData, date: e.target.value })}
                                    required
                                />
                            </div>
                            <div className="form-group">
                                <label className="form-label">Time</label>
                                <input
                                    type="time"
                                    className="form-input"
                                    value={bookingData.time}
                                    onChange={(e) => setBookingData({ ...bookingData, time: e.target.value })}
                                    required
                                />
                            </div>
                            <div style={{ display: 'flex', gap: '1rem' }}>
                                <button type="submit" className="btn btn-primary" style={{ flex: 1 }}>Confirm</button>
                                <button type="button" className="btn" style={{ flex: 1, backgroundColor: '#e5e7eb' }} onClick={() => setSelectedDoctor(null)}>Cancel</button>
                            </div>
                        </form>
                    </div>
                </div>
            )}
        </div>
    );
};

export default DoctorList;
