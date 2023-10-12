db.createCollection('Proveïdors', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Proveïdors',
      required: ['proveïdor_id', 'nom', 'telèfon', 'fax', 'NIF', 'Adreça'],
      properties: {
        proveïdor_id: {
          bsonType: 'objectId'
        },
        nom: {
          bsonType: 'string'
        },
        telèfon: {
          bsonType: 'int'
        },
        fax: {
          bsonType: 'int'
        },
        NIF: {
          bsonType: 'string'
        },
        Adreça: {
          bsonType: 'object',
          title: 'object',
          required: ['Carrer', 'Número', 'Ciutat', 'Codi Postal', 'País'],
          properties: {
            Carrer: {
              bsonType: 'string'
            },
            Número: {
              bsonType: 'int'
            },
            pis: {
              bsonType: 'int'
            },
            porta: {
              bsonType: 'int'
            },
            Ciutat: {
              bsonType: 'string'
            },
            Codi Postal: {
              bsonType: 'int'
            },
            País: {
              bsonType: 'string'
            }
          }
        }
      }
    }
  },
  capped:
});

db.createCollection('Marca', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Marca',
      required: ['marca_id', 'nom_marca', 'Proveïdors'],
      properties: {
        marca_id: {
          bsonType: 'objectId'
        },
        nom_marca: {
          bsonType: 'string'
        },
        Proveïdors: {
          bsonType: 'objectId'
        }
      }
    }
  },
  capped:
});

db.createCollection('Clients', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Clients',
      required: ['client_id', 'Nom', 'Adreça_Postal', 'Telèfon', 'Correu_electrònic', 'Data_registre'],
      properties: {
        client_id: {
          bsonType: 'objectId'
        },
        Nom: {
          bsonType: 'string'
        },
        Adreça_Postal: {
          bsonType: 'string'
        },
        Telèfon: {
          bsonType: 'int'
        },
        Correu_electrònic: {
          bsonType: 'string'
        },
        Data_registre: {
          bsonType: 'date'
        },
        Font_recomanació: {
          bsonType: 'string'
        }
      }
    }
  },
  capped:
});

db.createCollection('Ulleres', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Ulleres',
      required: ['ulleres_id', 'Graduació_ulleres', 'Tipus_montura', 'Color_montura', 'Color_vidre_dret', 'Color_vidre_esquerre', 'Preu', 'Marca'],
      properties: {
        ulleres_id: {
          bsonType: 'objectId'
        },
        Graduació_ulleres: {
          bsonType: 'int'
        },
        Tipus_montura: {
          bsonType: 'string'
        },
        Color_montura: {
          bsonType: 'string'
        },
        Color_vidre_dret: {
          bsonType: 'string'
        },
        Color_vidre_esquerre: {
          bsonType: 'string'
        },
        Preu: {
          bsonType: 'decimal'
        },
        Marca: {
          bsonType: 'objectId'
        }
      }
    }
  },
  capped:
});

db.createCollection('Venta', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Venta',
      required: ['venta_id', 'Ulleres', 'Venedor', 'Clients'],
      properties: {
        venta_id: {
          bsonType: 'objectId'
        },
        Ulleres: {
          bsonType: 'objectId'
        },
        Venedor: {
          bsonType: 'objectId'
        },
        Clients: {
          bsonType: 'objectId'
        }
      }
    }
  },
  capped:
});

db.createCollection('Venedor', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Venedor',
      required: ['venedor_id'],
      properties: {
        venedor_id: {
          bsonType: 'objectId'
        }
      }
    }
  },
  capped:
});