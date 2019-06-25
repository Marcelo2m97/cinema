--
-- PostgreSQL database dump
--

-- Dumped from database version 10.8
-- Dumped by pg_dump version 10.8

-- Started on 2019-06-25 22:00:54

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

--
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2921 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 205 (class 1259 OID 16789)
-- Name: ciudad; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ciudad (
    c_ciudad integer NOT NULL,
    ciudad_nombre character varying(50)
);


ALTER TABLE public.ciudad OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16787)
-- Name: ciudad_c_ciudad_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.ciudad_c_ciudad_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ciudad_c_ciudad_seq OWNER TO postgres;

--
-- TOC entry 2922 (class 0 OID 0)
-- Dependencies: 204
-- Name: ciudad_c_ciudad_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ciudad_c_ciudad_seq OWNED BY public.ciudad.c_ciudad;


--
-- TOC entry 203 (class 1259 OID 16781)
-- Name: estado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estado (
    c_estado integer NOT NULL,
    estado_nombre character varying(50)
);


ALTER TABLE public.estado OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16779)
-- Name: estado_c_estado_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.estado_c_estado_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.estado_c_estado_seq OWNER TO postgres;

--
-- TOC entry 2923 (class 0 OID 0)
-- Dependencies: 202
-- Name: estado_c_estado_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.estado_c_estado_seq OWNED BY public.estado.c_estado;


--
-- TOC entry 208 (class 1259 OID 16805)
-- Name: exhibicion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.exhibicion (
    c_exhibicion integer NOT NULL,
    c_usuariocreacion integer,
    c_usuariomodificacion integer,
    c_sala integer,
    c_pelicula integer,
    exhibicion_horario character varying(20),
    exhibicion_asientosdisponibles integer,
    exhibicion_creacion timestamp(4) without time zone,
    exhibicion_modificacion timestamp(4) without time zone,
    exhibicion_activo boolean,
    c_formato integer
);


ALTER TABLE public.exhibicion OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 16803)
-- Name: exhibicion_c_exhibicion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.exhibicion_c_exhibicion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.exhibicion_c_exhibicion_seq OWNER TO postgres;

--
-- TOC entry 2924 (class 0 OID 0)
-- Dependencies: 207
-- Name: exhibicion_c_exhibicion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.exhibicion_c_exhibicion_seq OWNED BY public.exhibicion.c_exhibicion;


--
-- TOC entry 214 (class 1259 OID 16945)
-- Name: formato; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.formato (
    c_formato integer NOT NULL,
    formato_nombre character varying(6),
    formato_precio money
);


ALTER TABLE public.formato OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 16943)
-- Name: formato_c_formato_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.formato_c_formato_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.formato_c_formato_seq OWNER TO postgres;

--
-- TOC entry 2925 (class 0 OID 0)
-- Dependencies: 213
-- Name: formato_c_formato_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.formato_c_formato_seq OWNED BY public.formato.c_formato;


--
-- TOC entry 201 (class 1259 OID 16773)
-- Name: pais; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pais (
    c_pais integer NOT NULL,
    pais_nombre character varying(50)
);


ALTER TABLE public.pais OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16771)
-- Name: pais_c_pais_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pais_c_pais_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pais_c_pais_seq OWNER TO postgres;

--
-- TOC entry 2926 (class 0 OID 0)
-- Dependencies: 200
-- Name: pais_c_pais_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pais_c_pais_seq OWNED BY public.pais.c_pais;


--
-- TOC entry 212 (class 1259 OID 16824)
-- Name: pelicula; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pelicula (
    c_pelicula integer NOT NULL,
    c_usuariocreacion integer,
    c_usuariomodificacion integer,
    pelicula_nombre character varying(100),
    pelicula_descripcion text,
    pelicula_activo boolean,
    pelicula_imagen text,
    pelicula_creacion timestamp(4) without time zone,
    pelicula_ultimamodificacion timestamp(4) without time zone
);


ALTER TABLE public.pelicula OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 16822)
-- Name: pelicula_c_pelicula_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pelicula_c_pelicula_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pelicula_c_pelicula_seq OWNER TO postgres;

--
-- TOC entry 2927 (class 0 OID 0)
-- Dependencies: 211
-- Name: pelicula_c_pelicula_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pelicula_c_pelicula_seq OWNED BY public.pelicula.c_pelicula;


--
-- TOC entry 206 (class 1259 OID 16797)
-- Name: reservacion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reservacion (
    c_usuario integer,
    c_exhibicion integer,
    reservacion_asientos character varying(5),
    reservacion_saldo money,
    reservacion_fecha timestamp without time zone,
    reservacion_grantotal money,
    c_reservacion integer NOT NULL
);


ALTER TABLE public.reservacion OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16956)
-- Name: reservacion_c_reservacion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.reservacion_c_reservacion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.reservacion_c_reservacion_seq OWNER TO postgres;

--
-- TOC entry 2928 (class 0 OID 0)
-- Dependencies: 215
-- Name: reservacion_c_reservacion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.reservacion_c_reservacion_seq OWNED BY public.reservacion.c_reservacion;


--
-- TOC entry 199 (class 1259 OID 16765)
-- Name: rol; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rol (
    c_rol integer NOT NULL,
    rol_nombre character varying(100)
);


ALTER TABLE public.rol OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 16763)
-- Name: rol_c_rol_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.rol_c_rol_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.rol_c_rol_seq OWNER TO postgres;

--
-- TOC entry 2929 (class 0 OID 0)
-- Dependencies: 198
-- Name: rol_c_rol_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.rol_c_rol_seq OWNED BY public.rol.c_rol;


--
-- TOC entry 210 (class 1259 OID 16813)
-- Name: sala; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sala (
    c_sala integer NOT NULL,
    c_usuariocreacion integer,
    c_usuariomodificacion integer,
    sala_numero integer,
    sala_descripcion text,
    sala_activo boolean,
    sala_capacidad integer,
    sala_creacion timestamp(4) without time zone,
    sala_ultimamodificacion timestamp(4) without time zone
);


ALTER TABLE public.sala OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 16811)
-- Name: sala_c_sala_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sala_c_sala_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sala_c_sala_seq OWNER TO postgres;

--
-- TOC entry 2930 (class 0 OID 0)
-- Dependencies: 209
-- Name: sala_c_sala_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.sala_c_sala_seq OWNED BY public.sala.c_sala;


--
-- TOC entry 197 (class 1259 OID 16753)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    c_usuario integer NOT NULL,
    c_pais integer,
    c_estado integer,
    c_ciudad integer,
    c_rol integer,
    u_nombre character varying(100),
    u_apellido character varying(100),
    u_fechanacimiento date,
    u_direccion text,
    u_username character varying(50),
    u_password character varying(50),
    u_activo boolean,
    u_sesion boolean,
    u_saldo money DEFAULT 20
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 16751)
-- Name: usuario_c_usuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuario_c_usuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_c_usuario_seq OWNER TO postgres;

--
-- TOC entry 2931 (class 0 OID 0)
-- Dependencies: 196
-- Name: usuario_c_usuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuario_c_usuario_seq OWNED BY public.usuario.c_usuario;


--
-- TOC entry 2732 (class 2604 OID 16792)
-- Name: ciudad c_ciudad; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ciudad ALTER COLUMN c_ciudad SET DEFAULT nextval('public.ciudad_c_ciudad_seq'::regclass);


--
-- TOC entry 2731 (class 2604 OID 16784)
-- Name: estado c_estado; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estado ALTER COLUMN c_estado SET DEFAULT nextval('public.estado_c_estado_seq'::regclass);


--
-- TOC entry 2734 (class 2604 OID 16808)
-- Name: exhibicion c_exhibicion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exhibicion ALTER COLUMN c_exhibicion SET DEFAULT nextval('public.exhibicion_c_exhibicion_seq'::regclass);


--
-- TOC entry 2737 (class 2604 OID 16948)
-- Name: formato c_formato; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formato ALTER COLUMN c_formato SET DEFAULT nextval('public.formato_c_formato_seq'::regclass);


--
-- TOC entry 2730 (class 2604 OID 16776)
-- Name: pais c_pais; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pais ALTER COLUMN c_pais SET DEFAULT nextval('public.pais_c_pais_seq'::regclass);


--
-- TOC entry 2736 (class 2604 OID 16827)
-- Name: pelicula c_pelicula; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pelicula ALTER COLUMN c_pelicula SET DEFAULT nextval('public.pelicula_c_pelicula_seq'::regclass);


--
-- TOC entry 2733 (class 2604 OID 16958)
-- Name: reservacion c_reservacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservacion ALTER COLUMN c_reservacion SET DEFAULT nextval('public.reservacion_c_reservacion_seq'::regclass);


--
-- TOC entry 2729 (class 2604 OID 16768)
-- Name: rol c_rol; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rol ALTER COLUMN c_rol SET DEFAULT nextval('public.rol_c_rol_seq'::regclass);


--
-- TOC entry 2735 (class 2604 OID 16816)
-- Name: sala c_sala; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sala ALTER COLUMN c_sala SET DEFAULT nextval('public.sala_c_sala_seq'::regclass);


--
-- TOC entry 2727 (class 2604 OID 16756)
-- Name: usuario c_usuario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario ALTER COLUMN c_usuario SET DEFAULT nextval('public.usuario_c_usuario_seq'::regclass);


--
-- TOC entry 2903 (class 0 OID 16789)
-- Dependencies: 205
-- Data for Name: ciudad; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ciudad (c_ciudad, ciudad_nombre) FROM stdin;
1	Sacramento
2	San Francisco
3	Miami
4	Orlando
5	Quebec
6	Motreal
7	Edson
8	Calgary
9	San Salvador
10	Ayutuxtepeque
11	El Congo
12	Santa Ana
\.


--
-- TOC entry 2901 (class 0 OID 16781)
-- Dependencies: 203
-- Data for Name: estado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.estado (c_estado, estado_nombre) FROM stdin;
1	California
2	Florida
3	Quebec
4	Alberta
5	San Salvador
6	Santa Ana
\.


--
-- TOC entry 2906 (class 0 OID 16805)
-- Dependencies: 208
-- Data for Name: exhibicion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.exhibicion (c_exhibicion, c_usuariocreacion, c_usuariomodificacion, c_sala, c_pelicula, exhibicion_horario, exhibicion_asientosdisponibles, exhibicion_creacion, exhibicion_modificacion, exhibicion_activo, c_formato) FROM stdin;
\.


--
-- TOC entry 2912 (class 0 OID 16945)
-- Dependencies: 214
-- Data for Name: formato; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.formato (c_formato, formato_nombre, formato_precio) FROM stdin;
1	2D-DOB	$2.00
2	2D-SUB	$2.00
3	3D-DOB	$4.00
4	3D-SUB	$4.00
\.


--
-- TOC entry 2899 (class 0 OID 16773)
-- Dependencies: 201
-- Data for Name: pais; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pais (c_pais, pais_nombre) FROM stdin;
1	Estados Unidos
2	Canada
3	El Salvador
\.


--
-- TOC entry 2910 (class 0 OID 16824)
-- Dependencies: 212
-- Data for Name: pelicula; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pelicula (c_pelicula, c_usuariocreacion, c_usuariomodificacion, pelicula_nombre, pelicula_descripcion, pelicula_activo, pelicula_imagen, pelicula_creacion, pelicula_ultimamodificacion) FROM stdin;
\.


--
-- TOC entry 2904 (class 0 OID 16797)
-- Dependencies: 206
-- Data for Name: reservacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.reservacion (c_usuario, c_exhibicion, reservacion_asientos, reservacion_saldo, reservacion_fecha, reservacion_grantotal, c_reservacion) FROM stdin;
\.


--
-- TOC entry 2897 (class 0 OID 16765)
-- Dependencies: 199
-- Data for Name: rol; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.rol (c_rol, rol_nombre) FROM stdin;
1	Administrador
2	Cliente
\.


--
-- TOC entry 2908 (class 0 OID 16813)
-- Dependencies: 210
-- Data for Name: sala; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sala (c_sala, c_usuariocreacion, c_usuariomodificacion, sala_numero, sala_descripcion, sala_activo, sala_capacidad, sala_creacion, sala_ultimamodificacion) FROM stdin;
\.


--
-- TOC entry 2895 (class 0 OID 16753)
-- Dependencies: 197
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario (c_usuario, c_pais, c_estado, c_ciudad, c_rol, u_nombre, u_apellido, u_fechanacimiento, u_direccion, u_username, u_password, u_activo, u_sesion, u_saldo) FROM stdin;
\.


--
-- TOC entry 2932 (class 0 OID 0)
-- Dependencies: 204
-- Name: ciudad_c_ciudad_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ciudad_c_ciudad_seq', 1, false);


--
-- TOC entry 2933 (class 0 OID 0)
-- Dependencies: 202
-- Name: estado_c_estado_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.estado_c_estado_seq', 1, false);


--
-- TOC entry 2934 (class 0 OID 0)
-- Dependencies: 207
-- Name: exhibicion_c_exhibicion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.exhibicion_c_exhibicion_seq', 5, true);


--
-- TOC entry 2935 (class 0 OID 0)
-- Dependencies: 213
-- Name: formato_c_formato_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.formato_c_formato_seq', 4, true);


--
-- TOC entry 2936 (class 0 OID 0)
-- Dependencies: 200
-- Name: pais_c_pais_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pais_c_pais_seq', 1, false);


--
-- TOC entry 2937 (class 0 OID 0)
-- Dependencies: 211
-- Name: pelicula_c_pelicula_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pelicula_c_pelicula_seq', 5, true);


--
-- TOC entry 2938 (class 0 OID 0)
-- Dependencies: 215
-- Name: reservacion_c_reservacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.reservacion_c_reservacion_seq', 4, true);


--
-- TOC entry 2939 (class 0 OID 0)
-- Dependencies: 198
-- Name: rol_c_rol_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.rol_c_rol_seq', 1, false);


--
-- TOC entry 2940 (class 0 OID 0)
-- Dependencies: 209
-- Name: sala_c_sala_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sala_c_sala_seq', 2, true);


--
-- TOC entry 2941 (class 0 OID 0)
-- Dependencies: 196
-- Name: usuario_c_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_c_usuario_seq', 1, false);


--
-- TOC entry 2747 (class 2606 OID 16794)
-- Name: ciudad ciudad_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ciudad
    ADD CONSTRAINT ciudad_pkey PRIMARY KEY (c_ciudad);


--
-- TOC entry 2745 (class 2606 OID 16786)
-- Name: estado estado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estado
    ADD CONSTRAINT estado_pkey PRIMARY KEY (c_estado);


--
-- TOC entry 2751 (class 2606 OID 16810)
-- Name: exhibicion exhibicion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exhibicion
    ADD CONSTRAINT exhibicion_pkey PRIMARY KEY (c_exhibicion);


--
-- TOC entry 2757 (class 2606 OID 16950)
-- Name: formato formato_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formato
    ADD CONSTRAINT formato_pkey PRIMARY KEY (c_formato);


--
-- TOC entry 2743 (class 2606 OID 16778)
-- Name: pais pais_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pais
    ADD CONSTRAINT pais_pkey PRIMARY KEY (c_pais);


--
-- TOC entry 2755 (class 2606 OID 16832)
-- Name: pelicula pelicula_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pelicula
    ADD CONSTRAINT pelicula_pkey PRIMARY KEY (c_pelicula);


--
-- TOC entry 2749 (class 2606 OID 16963)
-- Name: reservacion reservacion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservacion
    ADD CONSTRAINT reservacion_pkey PRIMARY KEY (c_reservacion);


--
-- TOC entry 2741 (class 2606 OID 16770)
-- Name: rol rol_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rol
    ADD CONSTRAINT rol_pkey PRIMARY KEY (c_rol);


--
-- TOC entry 2753 (class 2606 OID 16821)
-- Name: sala sala_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sala
    ADD CONSTRAINT sala_pkey PRIMARY KEY (c_sala);


--
-- TOC entry 2739 (class 2606 OID 16762)
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (c_usuario);


--
-- TOC entry 2768 (class 2606 OID 16951)
-- Name: exhibicion exhibicion_c_formato_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exhibicion
    ADD CONSTRAINT exhibicion_c_formato_fkey FOREIGN KEY (c_formato) REFERENCES public.formato(c_formato);


--
-- TOC entry 2765 (class 2606 OID 16868)
-- Name: exhibicion exhibicion_c_pelicula_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exhibicion
    ADD CONSTRAINT exhibicion_c_pelicula_fkey FOREIGN KEY (c_pelicula) REFERENCES public.pelicula(c_pelicula);


--
-- TOC entry 2764 (class 2606 OID 16863)
-- Name: exhibicion exhibicion_c_sala_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exhibicion
    ADD CONSTRAINT exhibicion_c_sala_fkey FOREIGN KEY (c_sala) REFERENCES public.sala(c_sala);


--
-- TOC entry 2766 (class 2606 OID 16930)
-- Name: exhibicion exhibicion_c_usuariocreacion_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exhibicion
    ADD CONSTRAINT exhibicion_c_usuariocreacion_fkey FOREIGN KEY (c_usuariocreacion) REFERENCES public.usuario(c_usuario);


--
-- TOC entry 2767 (class 2606 OID 16935)
-- Name: exhibicion exhibicion_c_usuariomodificacion_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exhibicion
    ADD CONSTRAINT exhibicion_c_usuariomodificacion_fkey FOREIGN KEY (c_usuariomodificacion) REFERENCES public.usuario(c_usuario);


--
-- TOC entry 2771 (class 2606 OID 16883)
-- Name: pelicula pelicula_c_usuariocreacion_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pelicula
    ADD CONSTRAINT pelicula_c_usuariocreacion_fkey FOREIGN KEY (c_usuariocreacion) REFERENCES public.usuario(c_usuario);


--
-- TOC entry 2772 (class 2606 OID 16888)
-- Name: pelicula pelicula_c_usuariomodificacion_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pelicula
    ADD CONSTRAINT pelicula_c_usuariomodificacion_fkey FOREIGN KEY (c_usuariomodificacion) REFERENCES public.usuario(c_usuario);


--
-- TOC entry 2763 (class 2606 OID 16858)
-- Name: reservacion reservacion_c_exhibicion_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservacion
    ADD CONSTRAINT reservacion_c_exhibicion_fkey FOREIGN KEY (c_exhibicion) REFERENCES public.exhibicion(c_exhibicion);


--
-- TOC entry 2762 (class 2606 OID 16853)
-- Name: reservacion reservacion_c_usuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservacion
    ADD CONSTRAINT reservacion_c_usuario_fkey FOREIGN KEY (c_usuario) REFERENCES public.usuario(c_usuario);


--
-- TOC entry 2769 (class 2606 OID 16873)
-- Name: sala sala_c_usuariocreacion_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sala
    ADD CONSTRAINT sala_c_usuariocreacion_fkey FOREIGN KEY (c_usuariocreacion) REFERENCES public.usuario(c_usuario);


--
-- TOC entry 2770 (class 2606 OID 16878)
-- Name: sala sala_c_usuariomodificacion_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sala
    ADD CONSTRAINT sala_c_usuariomodificacion_fkey FOREIGN KEY (c_usuariomodificacion) REFERENCES public.usuario(c_usuario);


--
-- TOC entry 2760 (class 2606 OID 16843)
-- Name: usuario usuario_c_ciudad_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_c_ciudad_fkey FOREIGN KEY (c_ciudad) REFERENCES public.ciudad(c_ciudad);


--
-- TOC entry 2759 (class 2606 OID 16838)
-- Name: usuario usuario_c_estado_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_c_estado_fkey FOREIGN KEY (c_estado) REFERENCES public.estado(c_estado);


--
-- TOC entry 2758 (class 2606 OID 16833)
-- Name: usuario usuario_c_pais_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_c_pais_fkey FOREIGN KEY (c_pais) REFERENCES public.pais(c_pais);


--
-- TOC entry 2761 (class 2606 OID 16848)
-- Name: usuario usuario_c_rol_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_c_rol_fkey FOREIGN KEY (c_rol) REFERENCES public.rol(c_rol);


-- Completed on 2019-06-25 22:01:00

--
-- PostgreSQL database dump complete
--

