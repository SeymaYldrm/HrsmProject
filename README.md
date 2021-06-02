-> hrms-sql-data -> hrms.sql

CREATE TABLE "public"."job_seeker_verifacition_codes"( "id" int NOT NULL, "job_seeker_id" int NOT NULL);

CREATE TABLE "public"."employers_verifacition_codes"( "id" int NOT NULL, "employer_id" int NOT NULL);

CREATE TABLE "public"."verifacition_codes"( "id" int NOT NULL, "activation_code" varchar(38) NOT NULL, "is_confirmed" boolean NOT NULL, "confirmed_date" date NOT NULL);

CREATE TABLE "public"."job_seeker"( "id" int NOT NULL, "first_name" varchar(25) NOT NULL, "last_name" varchar(25) NOT NULL, "identity_number" varchar(11) NOT NULL, "birth_date" date NOT NULL);

CREATE TABLE "public"."staff"( "id" int NOT NULL, "first_name" varchar(25) NOT NULL, "last_name" varchar(25) NOT NULL);

CREATE TABLE "public"."employer_verifacition_by_staff"( "id" int NOT NULL, "employer_id" int NOT NULL, "confirmed_staff_id" int, "is_confirmed" boolean NOT NULL, "confirmed_date" date);

CREATE TABLE "public"."employers"( "id" int NOT NULL, "company_name" varchar(255) NOT NULL, "web_address" varchar(50) NOT NULL, "phone_number" varchar(12) NOT NULL, "is_activated" boolean NOT NULL);

CREATE TABLE "public"."job_titles"( "id" int NOT NULL, "title" varchar(50) NOT NULL);

CREATE TABLE "public"."users"( "id" int NOT NULL, "email" varchar(50) NOT NULL, "password" varchar(25) NOT NULL);

-- KEYS

CREATE SEQUENCE "public"."verifacition_codes_id_seq" INCREMENT BY 1 START WITH 1 OWNED BY "public"."verifacition_codes"."id";

CREATE SEQUENCE "public"."employer_verifacition_by_staff_id_seq" INCREMENT BY 1 START WITH 1 OWNED BY "public"."employer_verifacition_by_staff"."id";

CREATE SEQUENCE "public"."job_titles_id_seq" INCREMENT BY 1 START WITH 1 OWNED BY "public"."job_titles"."id";

CREATE SEQUENCE "public"."users_id_seq" INCREMENT BY 1 START WITH 1 OWNED BY "public"."users"."id";

ALTER TABLE "public"."job_seeker_verifacition_codes" ADD CONSTRAINT "pk_verifacition_code_job_seeker" PRIMARY KEY ("id");

ALTER TABLE "public"."employers_verifacition_codes" ADD CONSTRAINT "pk_verifacition_code_employers" PRIMARY KEY ("id");

ALTER TABLE "public"."verifacition_codes" ADD CONSTRAINT "pk_verifacition_codes" PRIMARY KEY ("id");

ALTER TABLE "public"."job_seeker" ADD CONSTRAINT "pk_job_seeker_id" PRIMARY KEY ("id");

ALTER TABLE "public"."staff" ADD CONSTRAINT "pk_staff_id" PRIMARY KEY ("id");

ALTER TABLE "public"."employer_verifacition_by_staff" ADD CONSTRAINT "pk_employeractivationstaff_id" PRIMARY KEY ("id");

ALTER TABLE "public"."employers" ADD CONSTRAINT "pk_employers_id" PRIMARY KEY ("id");

ALTER TABLE "public"."job_titles" ADD CONSTRAINT "pk_job_titles_id" PRIMARY KEY ("id");

ALTER TABLE "public"."users" ADD CONSTRAINT "pk_users_id" PRIMARY KEY ("id");

ALTER TABLE "public"."verifacition_codes" ADD CONSTRAINT "uc_verifacition_codes" UNIQUE ("verifacition_code");

ALTER TABLE "public"."job_seeker" ADD CONSTRAINT "uc_job_seeker_identity_number" UNIQUE ("identity_number");

ALTER TABLE "public"."job_titles" ADD CONSTRAINT "uc_job_titles_title" UNIQUE ("title");

ALTER TABLE "public"."users" ADD CONSTRAINT "uc_users_email" UNIQUE ("email");

ALTER TABLE "public"."job_seeker_verifacition_codes" ADD CONSTRAINT "fk_verifacition_codes_job_seeker_job_seeker" FOREIGN KEY ("job_seeker_id") REFERENCES "public"."job_seeker" ( "id");

ALTER TABLE "public"."employers_verifacition_codes" ADD CONSTRAINT "fk_verifacition_code_employers_employers" FOREIGN KEY ("employer_id") REFERENCES "public"."employers" ( "id");

ALTER TABLE "public"."verifacition_codes" ADD CONSTRAINT "fk_verifacition_codes_verifacition_codes_job_seeker" FOREIGN KEY ("id") REFERENCES "public"."job_seeker_verifacition_codes" ( "id");

ALTER TABLE "public"."verifacition_codes" ADD CONSTRAINT "fk_verifacition_codes_verifacition_code_employers" FOREIGN KEY ("id") REFERENCES "public"."employers_verifacition_codes" ( "id");

ALTER TABLE "public"."job_seeker" ADD CONSTRAINT "fk_job_seeker_users" FOREIGN KEY ("id") REFERENCES "public"."users" ( "id");

ALTER TABLE "public"."staff" ADD CONSTRAINT "fk_staff_users" FOREIGN KEY ("id") REFERENCES "public"."users" ( "id");

ALTER TABLE "public"."employer_verifacition_by_staff" ADD CONSTRAINT "fk_employer_verifacition_staff_staff" FOREIGN KEY ("confirmed_staff_id") REFERENCES "public"."staff" ( "id");

ALTER TABLE "public"."employer_verifacition_by_staff" ADD CONSTRAINT "fk_employer_verifacition_staff_employers" FOREIGN KEY ("employer_id") REFERENCES "public"."employers" ( "id");

ALTER TABLE "public"."employers" ADD CONSTRAINT "fk_employers_users" FOREIGN KEY ("id") REFERENCES "public"."users" ( "id");

ALTER TABLE "public"."verifacition_codes" ALTER COLUMN "id" SET DEFAULT nextval('"public"."verifacition_codes_id_seq"');

ALTER TABLE "public"."employer_verifacition_by_staff" ALTER COLUMN "id" SET DEFAULT nextval('"public"."employer_verifacition_by_staff_id_seq"');

ALTER TABLE "public"."employer_verifacition_by_staff" ALTER COLUMN "is_confirmed" SET DEFAULT false;

ALTER TABLE "public"."employers" ALTER COLUMN "is_activated" SET DEFAULT false;

ALTER TABLE "public"."job_titles" ALTER COLUMN "id" SET DEFAULT nextval('"public"."job_titles_id_seq"');

ALTER TABLE "public"."users" ALTER COLUMN "id" SET DEFAULT nextval('"public"."users_id_seq"');

INSERT INTO "public"."job_titles" (title) VALUES ('Software Developer'),('Software Architect');