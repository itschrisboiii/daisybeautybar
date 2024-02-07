--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1
-- Dumped by pg_dump version 16.1

-- Started on 2024-02-07 09:57:23 PST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 218 (class 1259 OID 16490)
-- Name: appointment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.appointment (
    id integer NOT NULL,
    appointment_date date NOT NULL,
    appointment_time time without time zone NOT NULL,
    client_id integer NOT NULL,
    service_id integer NOT NULL
);


ALTER TABLE public.appointment OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16489)
-- Name: appointment_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.appointment_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.appointment_id_seq OWNER TO postgres;

--
-- TOC entry 3615 (class 0 OID 0)
-- Dependencies: 217
-- Name: appointment_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.appointment_id_seq OWNED BY public.appointment.id;


--
-- TOC entry 216 (class 1259 OID 16483)
-- Name: client; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.client (
    id integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    email character varying(50) NOT NULL
);


ALTER TABLE public.client OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16482)
-- Name: client_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.client_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.client_id_seq OWNER TO postgres;

--
-- TOC entry 3616 (class 0 OID 0)
-- Dependencies: 215
-- Name: client_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.client_id_seq OWNED BY public.client.id;


--
-- TOC entry 220 (class 1259 OID 16497)
-- Name: services; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.services (
    id integer NOT NULL,
    service_name character varying(50) NOT NULL,
    price integer NOT NULL
);


ALTER TABLE public.services OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16496)
-- Name: services_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.services_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.services_id_seq OWNER TO postgres;

--
-- TOC entry 3617 (class 0 OID 0)
-- Dependencies: 219
-- Name: services_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.services_id_seq OWNED BY public.services.id;


--
-- TOC entry 3451 (class 2604 OID 16493)
-- Name: appointment id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.appointment ALTER COLUMN id SET DEFAULT nextval('public.appointment_id_seq'::regclass);


--
-- TOC entry 3450 (class 2604 OID 16486)
-- Name: client id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client ALTER COLUMN id SET DEFAULT nextval('public.client_id_seq'::regclass);


--
-- TOC entry 3452 (class 2604 OID 16500)
-- Name: services id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.services ALTER COLUMN id SET DEFAULT nextval('public.services_id_seq'::regclass);


--
-- TOC entry 3607 (class 0 OID 16490)
-- Dependencies: 218
-- Data for Name: appointment; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.appointment (id, appointment_date, appointment_time, client_id, service_id) VALUES (2, '2024-02-15', '16:00:00', 1, 1);
INSERT INTO public.appointment (id, appointment_date, appointment_time, client_id, service_id) VALUES (3, '2024-03-08', '14:00:00', 1, 1);
INSERT INTO public.appointment (id, appointment_date, appointment_time, client_id, service_id) VALUES (1, '2024-02-03', '12:00:00', 1, 1);


--
-- TOC entry 3605 (class 0 OID 16483)
-- Dependencies: 216
-- Data for Name: client; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.client (id, first_name, last_name, email) VALUES (1, 'chris', 'loya', 'cloya100@gmail.com');
INSERT INTO public.client (id, first_name, last_name, email) VALUES (2, 'daisy', 'carreno', 'daisy@email.com');
INSERT INTO public.client (id, first_name, last_name, email) VALUES (3, 'chris', 'loya', 'cloya100@gmail.com');
INSERT INTO public.client (id, first_name, last_name, email) VALUES (4, 'Rob', 'Dyke', 'robdyke69@hotmales.com');
INSERT INTO public.client (id, first_name, last_name, email) VALUES (5, 'Chris', 'Loya', 'chris89@hotmail.com');


--
-- TOC entry 3609 (class 0 OID 16497)
-- Dependencies: 220
-- Data for Name: services; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.services (id, service_name, price) VALUES (2, 'classic', 50);
INSERT INTO public.services (id, service_name, price) VALUES (3, 'Hybrid', 60);
INSERT INTO public.services (id, service_name, price) VALUES (1, 'CATEYE', 100);


--
-- TOC entry 3618 (class 0 OID 0)
-- Dependencies: 217
-- Name: appointment_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.appointment_id_seq', 6, true);


--
-- TOC entry 3619 (class 0 OID 0)
-- Dependencies: 215
-- Name: client_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.client_id_seq', 5, true);


--
-- TOC entry 3620 (class 0 OID 0)
-- Dependencies: 219
-- Name: services_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.services_id_seq', 4, true);


--
-- TOC entry 3456 (class 2606 OID 16495)
-- Name: appointment appointment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.appointment
    ADD CONSTRAINT appointment_pkey PRIMARY KEY (id);


--
-- TOC entry 3454 (class 2606 OID 16488)
-- Name: client client_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id);


--
-- TOC entry 3458 (class 2606 OID 16502)
-- Name: services services_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.services
    ADD CONSTRAINT services_pkey PRIMARY KEY (id);


--
-- TOC entry 3459 (class 2606 OID 16503)
-- Name: appointment appointment_client_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.appointment
    ADD CONSTRAINT appointment_client_id_fkey FOREIGN KEY (client_id) REFERENCES public.client(id) NOT VALID;


--
-- TOC entry 3460 (class 2606 OID 16508)
-- Name: appointment appointment_service_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.appointment
    ADD CONSTRAINT appointment_service_id_fkey FOREIGN KEY (service_id) REFERENCES public.services(id) NOT VALID;


-- Completed on 2024-02-07 09:57:23 PST

--
-- PostgreSQL database dump complete
--

