package com.daisybeautybar.springbackend.dao;


import com.daisybeautybar.springbackend.exception.DaoException;
import com.daisybeautybar.springbackend.model.Appointment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcAppointmentDao implements AppointmentDao{


    private final JdbcTemplate jdbcTemplate;
    public JdbcAppointmentDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Appointment getAppointmentById(int appointmentId) {
        Appointment appointment = null;
        String sql = "SELECT * " +
                     "FROM appointment " +
                     "WHERE id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, appointmentId);
            if (results.next()) {
                appointment = mapRowToAppointment(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return appointment;
    }

    @Override
    public Appointment getAppointmentByDate(String date) {
        Appointment appointment = null;
        String sql = "SELECT * FROM appointment " +
                "WHERE date = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, date);
            if (results.next()) {
                appointment = mapRowToAppointment(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return appointment;
    }

    @Override
    public List<Appointment> getAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointment;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Appointment appointment = mapRowToAppointment(results);
                appointments.add(appointment);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return appointments;
    }

    @Override
    public Appointment createAppointment(Appointment newAppointment) {
        Appointment appointment = null;
        String sql = "INSERT INTO appointment (appointment_date, appointment_time, client_id, service_id) " +
                "VALUES (?, ?, ?, ?) RETURNING id;";
        try {
            int newAppointmentId = jdbcTemplate.queryForObject(sql, int.class, newAppointment.getDate(),
            newAppointment.getTime(), newAppointment.getClient_id(), newAppointment.getService_id());
            appointment = getAppointmentById(newAppointmentId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return appointment;
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
        Appointment updatedAppointment = null;
        String sql = "UPDATE appointment SET appointment_date=?, appointment_time=?, client_id=?, service_id=? WHERE id = ?;";

        try {
            jdbcTemplate.update(sql, appointment.getDate(), appointment.getTime(), appointment.getClient_id(), appointment.getService_id(), appointment.getId());
            updatedAppointment = getAppointmentById(appointment.getId());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return updatedAppointment;
    }

    @Override
    public int cancelAppointmentById(int appointmentId) {
        int numberOfRows = 0;
        String sql = "DELETE FROM appointment WHERE id = ?;";


        try {
            numberOfRows = jdbcTemplate.update(sql, appointmentId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return numberOfRows;
    }

    private Appointment mapRowToAppointment(SqlRowSet rowSet) {
        Appointment appointment = new Appointment();
        appointment.setId(rowSet.getInt("id")); //  change
        appointment.setDate(rowSet.getDate("appointment_date").toLocalDate()); // change
        appointment.setTime(Time.valueOf(rowSet.getTime("appointment_time").toLocalTime()));
        appointment.setClient_id(rowSet.getInt("client_id"));
        appointment.setService_id(rowSet.getInt("service_id"));
        return appointment;
    }
}
