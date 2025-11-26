import React, { useState, useEffect, useContext } from 'react';
import api from '../services/api';
import { AuthContext } from '../context/AuthContext';

const PatientDashboard = () => {
    const [appointments, setAppointments] = useState([]);
    const { user } = useContext(AuthContext);

    useEffect(() => {
        if (user) {
            fetchAppointments();
        }
    }, [user]);

    const fetchAppointments = async () => {
        try {
            const response = await api.get(`/appointments/patient/${user.id}`);
            setAppointments(response.data);
        } catch (err) {
            console.error('Error fetching appointments:', err);
        }
    };

    const handleCancel = async (id) => {
        if (window.confirm('Are you sure you want to cancel this appointment?')) {
            try {
                await api.put(`/appointments/${id}/cancel`);
                fetchAppointments(); // Refresh list
            } catch (err) {
                console.error('Error cancelling appointment:', err);
            }
        }
    };

    return (
        <div className="container">
            <h2 style={{ marginBottom: '1.5rem' }}>My Appointments</h2>
            {appointments.length === 0 ? (
                <p>No appointments found.</p>
            ) : (
                <div style={{ display: 'grid', gap: '1rem' }}>
                    {appointments.map((apt) => (
                        <div key={apt.id} className="card" style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
                            <div>
                                <h3>Dr. {apt.doctor.name}</h3>
                                <p style={{ color: '#6b7280' }}>{apt.doctor.specialization}</p>
                                <p><strong>Date:</strong> {apt.appointmentDate} at {apt.appointmentTime}</p>
                                <p>
                                    <strong>Status:</strong>
                                    <span style={{
                                        marginLeft: '0.5rem',
                                        color: apt.status === 'BOOKED' ? '#059669' : '#dc2626',
                                        fontWeight: 600
                                    }}>
                                        {apt.status}
                                    </span>
                                </p>
                            </div>
                            {apt.status === 'BOOKED' && (
                                <button
                                    className="btn"
                                    style={{ backgroundColor: '#fee2e2', color: '#b91c1c' }}
                                    onClick={() => handleCancel(apt.id)}
                                >
                                    Cancel
                                </button>
                            )}
                        </div>
                    ))}
                </div>
            )}
        </div>
    );
};

export default PatientDashboard;
