# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table bouteille (
  id                        bigint not null,
  cave_id                   bigint,
  appellation               varchar(255),
  millesime                 integer,
  couleur                   varchar(5),
  degre_alcool              integer,
  volume_bouteille          integer,
  qr_code                   varchar(255),
  prix_achat                integer,
  is_available              boolean,
  date_ouverture            timestamp,
  date_creation             timestamp,
  derniere_modification     timestamp,
  constraint ck_bouteille_couleur check (couleur in ('AUTRE','BLANC','ROSE','ROUGE')),
  constraint pk_bouteille primary key (id))
;

create table cave (
  id                        bigint not null,
  owner_id                  bigint,
  bouteille_max             integer,
  valeur_max                double,
  creation_date             timestamp not null,
  last_update_date          timestamp not null,
  constraint pk_cave primary key (id))
;

create table user (
  id                        bigint not null,
  email                     varchar(255) not null,
  password                  varchar(255),
  creation_date             timestamp,
  last_connection_date      timestamp,
  constraint uq_user_email unique (email),
  constraint pk_user primary key (id))
;

create sequence bouteille_seq;

create sequence cave_seq;

create sequence user_seq;

alter table bouteille add constraint fk_bouteille_cave_1 foreign key (cave_id) references cave (id) on delete restrict on update restrict;
create index ix_bouteille_cave_1 on bouteille (cave_id);
alter table cave add constraint fk_cave_owner_2 foreign key (owner_id) references user (id) on delete restrict on update restrict;
create index ix_cave_owner_2 on cave (owner_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists bouteille;

drop table if exists cave;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists bouteille_seq;

drop sequence if exists cave_seq;

drop sequence if exists user_seq;

