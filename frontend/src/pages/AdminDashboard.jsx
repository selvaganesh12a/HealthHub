import React, { useState, useEffect } from 'react';
import api from '../services/api';

const AdminDashboard = () => {
    const [doctors, setDoctors] = useState([]);
    const [appointments, setAppointments] = useState([]);
    const [activeTab, setActiveTab] = useState('appointments'); // 'appointments' or 'doctors'
    const [newDoctor, setNewDoctor] = useState({
        name: '',
        specialization: '',
        experience: '',
        consultationFee: '',
        availableDays: ''
    });
    const [message, setMessage] = useState('');

    useEffect(() => {
        fetchDoctors();
        fetchAppointments();
    }, []);

    const fetchDoctors = async () => {
        try {
            const response = await api.get('/doctors');
            setDoctors(response.data);
        } catch (err) {
            console.error('Error fetching doctors:', err);
        }
    };

    const fetchAppointments = async () => {
        try {
            const response = await api.get('/appointments');
            setAppointments(response.data);
        } catch (err) {
            console.error('Error fetching appointments:', err);
        }
    };

    const handleAddDoctor = async (e) => {
        e.preventDefault();
        try {
            if (newDoctor.id) {
                await api.put(`/doctors/${newDoctor.id}`, newDoctor);
                setMessage('Doctor updated successfully!');
            } else {
                await api.post('/doctors', newDoctor);
                setMessage('Doctor added successfully!');
            }
            setNewDoctor({ name: '', specialization: '', experience: '', consultationFee: '', availableDays: '' });
            fetchDoctors();
        } catch (err) {
            setMessage('Failed to save doctor');
        }
    };

    const handleDeleteDoctor = async (id) => {
        if (window.confirm('Are you sure?')) {
            try {
                await api.delete(`/doctors/${id}`);
                fetchDoctors();
            } catch (err) {
                console.error('Error deleting doctor:', err);
            }
        }
    };

    return (
        <div className="container">
            <h2 style={{ marginBottom: '1.5rem' }}>Admin Dashboard</h2>

            <div style={{ marginBottom: '1.5rem', display: 'flex', gap: '1rem' }}>
                <button
                    className={`btn ${activeTab === 'appointments' ? 'btn-primary' : ''}`}
                    style={{ backgroundColor: activeTab !== 'appointments' ? '#e5e7eb' : '' }}
                    onClick={() => setActiveTab('appointments')}
                >
                    All Appointments
                </button>
                <button
                    className={`btn ${activeTab === 'doctors' ? 'btn-primary' : ''}`}
                    style={{ backgroundColor: activeTab !== 'doctors' ? '#e5e7eb' : '' }}
                    onClick={() => setActiveTab('doctors')}
                >
                    Manage Doctors
                </button>
            </div>

            {message && <div className="card" style={{ marginBottom: '1rem', padding: '1rem', backgroundColor: '#d1fae5', color: '#065f46' }}>{message}</div>}

            {activeTab === 'appointments' && (
                <div className="card">
                    <h3>All Appointments</h3>
                    <div style={{ overflowX: 'auto', marginTop: '1rem' }}>
                        <table style={{ width: '100%', borderCollapse: 'collapse' }}>
                            <thead>
                                <tr style={{ borderBottom: '2px solid #e5e7eb', textAlign: 'left' }}>
                                    <th style={{ padding: '0.75rem' }}>ID</th>
                                    <th style={{ padding: '0.75rem' }}>Patient</th>
                                    <th style={{ padding: '0.75rem' }}>Doctor</th>
                                    <th style={{ padding: '0.75rem' }}>Date</th>
                                    <th style={{ padding: '0.75rem' }}>Time</th>
                                    <th style={{ padding: '0.75rem' }}>Status</th>
                                </tr>
                            </thead>
                            <tbody>
                                {appointments.map((apt) => (
                                    <tr key={apt.id} style={{ borderBottom: '1px solid #e5e7eb' }}>
                                        <td style={{ padding: '0.75rem' }}>{apt.id}</td>
                                        <td style={{ padding: '0.75rem' }}>{apt.patient.username}</td>
                                        <td style={{ padding: '0.75rem' }}>{apt.doctor.name}</td>
                                        <td style={{ padding: '0.75rem' }}>{apt.appointmentDate}</td>
                                        <td style={{ padding: '0.75rem' }}>{apt.appointmentTime}</td>
                                        <td style={{ padding: '0.75rem', color: apt.status === 'BOOKED' ? '#059669' : '#dc2626' }}>{apt.status}</td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </div>
                </div>
            )}

            {activeTab === 'doctors' && (
                <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '2rem' }}>
                    <div className="card">
                        <h3>{newDoctor.id ? 'Edit Doctor' : 'Add New Doctor'}</h3>
                        <form onSubmit={handleAddDoctor} style={{ marginTop: '1rem' }}>
                            <div className="form-group">
                                <label className="form-label">Name</label>
                                <input type="text" className="form-input" value={newDoctor.name} onChange={(e) => setNewDoctor({ ...newDoctor, name: e.target.value })} required />
                            </div>
                            <div className="form-group">
                                <label className="form-label">Specialization</label>
                                <input type="text" className="form-input" value={newDoctor.specialization} onChange={(e) => setNewDoctor({ ...newDoctor, specialization: e.target.value })} required />
                            </div>
                            <div className="form-group">
                                <label className="form-label">Experience (Years)</label>
                                <input type="number" className="form-input" value={newDoctor.experience} onChange={(e) => setNewDoctor({ ...newDoctor, experience: e.target.value })} required />
                            </div>
                            <div className="form-group">
                                <label className="form-label">Fee</label>
                                <input type="number" className="form-input" value={newDoctor.consultationFee} onChange={(e) => setNewDoctor({ ...newDoctor, consultationFee: e.target.value })} required />
                            </div>
                            <div className="form-group">
                                <label className="form-label">Available Days</label>
                                <input type="text" className="form-input" placeholder="e.g. MON,WED,FRI" value={newDoctor.availableDays} onChange={(e) => setNewDoctor({ ...newDoctor, availableDays: e.target.value })} required />
                            </div>
                            <div style={{ display: 'flex', gap: '1rem' }}>
                                <button type="submit" className="btn btn-primary" style={{ flex: 1 }}>{newDoctor.id ? 'Update Doctor' : 'Add Doctor'}</button>
                                {newDoctor.id && (
                                    <button
                                        type="button"
                                        className="btn"
                                        style={{ flex: 1, backgroundColor: '#e5e7eb' }}
                                        onClick={() => setNewDoctor({ name: '', specialization: '', experience: '', consultationFee: '', availableDays: '' })}
                                    >
                                        Cancel
                                    </button>
                                )}
                            </div>
                        </form>
                    </div>

                    <div className="card">
                        <h3>Existing Doctors</h3>
                        <div style={{ marginTop: '1rem', display: 'flex', flexDirection: 'column', gap: '0.5rem' }}>
                            {doctors.map((doc) => (
                                <div key={doc.id} style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '0.5rem', borderBottom: '1px solid #e5e7eb' }}>
                                    <div>
                                        <strong>{doc.name}</strong>
                                        <span style={{ fontSize: '0.875rem', color: '#6b7280', marginLeft: '0.5rem' }}>{doc.specialization}</span>
                                    </div>
                                    <div>
                                        <button className="btn" style={{ padding: '0.25rem 0.5rem', fontSize: '0.875rem', backgroundColor: '#d1fae5', color: '#065f46', marginRight: '0.5rem' }} onClick={() => setNewDoctor(doc)}>Edit</button>
                                        <button className="btn" style={{ padding: '0.25rem 0.5rem', fontSize: '0.875rem', backgroundColor: '#fee2e2', color: '#b91c1c' }} onClick={() => handleDeleteDoctor(doc.id)}>Delete</button>
                                    </div>
                                </div>
                            ))}
                        </div>
                    </div>
                </div>
            )}
        </div>
    );
};

export default AdminDashboard;
