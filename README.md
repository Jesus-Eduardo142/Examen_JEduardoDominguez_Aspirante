# Examen_JEduardoDominguez_Aspirante
Nombre: Jesus Eduardo Dominguez Aguirre
Puerto Postgres: 5433


#Insert's

INSERT INTO public.propietarios(
	id, apellido_materno, apellido_paterno, correo_electronico, direccion, nombre, telefono)
	VALUES (1, 'Domiguez', 'Reyes', 'car@gmail.com', 'norte 2', 'Juab', '272686039'),
	(2, 'Gaspar', 'Aguirre', 'fati@gmail.com', 'norte 5', 'Wendy', '27275893560'),
	(3, 'Garcia', 'Garcia', 'car@gmail.com', 'poniete 10', 'Aldo', '2725680384');

INSERT INTO public.razas_mascotas(
	id, nombre)
	VALUES (1, 'Pastor alemán'),
	(2, 'Labrador'),
	(3, 'Bulldog'),
	(4, 'Persa'),
	(5, 'Bengala'),
	(6, 'Ragdoll');

INSERT INTO public.tipos_mascotas(
	id, nombre)
	VALUES (1, 'Perro'),
	(2, 'Gato');


INSERT INTO public.tipos_vacunas(
	id, descripcion, dosis, nombre)
	VALUES (1, 'rabia dosis 1', 1, 'rabia'),
	(2, 'rabia dosis 2', 1, 'rabia'),
	(3, 'primera vacuna', 1, 'Primovacunacion '),
	(4, '', 1, 'Polivalente'),
	(5, 'Recordatorio de la Polivalente', 1, 'Polivalente ');


INSERT INTO public.veterinarios(
	id, apellido_materno, apellido_paterno, correo_electronico, direccion, nombre, telefono)
	VALUES (1, 'Arenas', 'Reyes', 'car@gmail.com', 'norte 2', 'Carlos', '2721893456'),
	(2, 'Tello', 'Aguirre', 'fati@gmail.com', 'norte 5', 'Fatima', '2724573290'),
	(3, 'Ramirez', 'Garcia', 'car@gmail.com', 'poniete 10', 'Miriam', '272125806');


INSERT INTO public.mascotas(
	id, descripcion, edad, fecha_nacimiento, nombre, sexo, propietario_id, raza_id, tipo_id)
	VALUES (1, '', 2, '25-05-2021', 'lazy', 'hembra', 1, 1, 1),
	(2, '', 1, '12-06-2020', 'cookis', 'hembra', 2, 2, 1),
	(3, '', 2, '01-02-2021', 'valto', 'macho', 3, 3, 1),
	(4, '', 2, '02-12-2019', 'kayla', 'hembra', 1, 2, 2),
	(5, '', 1, '17-10-2020', 'lukas', 'macho', 3, 3, 2);


INSERT INTO public.vacunas(
	id, observacion, fecha, mascota_id, tipo_id, veterinario_id)
	VALUES (1, 'ninguna', '22-03-2021', 1, 1, 1),
	(2, 'ninguna', '12-03-2021', 2, 1, 2),
	(3, 'ninguna', '02-12-2020', 3, 2, 3),
	(4, 'ninguna', '11-08-2019', 2, 3, 1),
	(5, 'ninguna', '19-12-2020', 3, 4, 1),
	(6, 'ninguna', '15-01-2019', 4, 1, 3),
	(7, 'ninguna', '20-05-2020', 5, 2, 2),
	(8, 'ninguna', '30-12-2020', 5, 4, 1);

