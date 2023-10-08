db.createCollection('Provínices', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Provínices',
      required: ['província_id', 'nom'],
      properties: {
        província_id: {
          bsonType: 'objectId'
        },
        nom: {
          bsonType: 'string'
        }
      }
    }
  },
  capped:
});

db.createCollection('Localitats', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Localitats',
      required: ['localitat_id', 'nom', 'Provínices'],
      properties: {
        localitat_id: {
          bsonType: 'objectId'
        },
        nom: {
          bsonType: 'string'
        },
        Provínices: {
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
      required: ['client_id', 'nom', 'Cognoms', 'Info', 'Provínices', 'Localitats'],
      properties: {
        client_id: {
          bsonType: 'objectId'
        },
        nom: {
          bsonType: 'string'
        },
        Cognoms: {
          bsonType: 'string'
        },
        Info: {
          bsonType: 'object',
          title: 'object',
          required: ['Adreça', 'Codi_postal', 'Telèfon'],
          properties: {
            Adreça: {
              bsonType: 'string'
            },
            Codi_postal: {
              bsonType: 'int'
            },
            Telèfon: {
              bsonType: 'int'
            }
          }
        },
        Provínices: {
          bsonType: 'objectId'
        },
        Localitats: {
          bsonType: 'objectId'
        }
      }
    }
  },
  capped:
});

db.createCollection('Botigues', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Botigues',
      required: ['Botiga_id', 'Adreça', 'Codi_postal', 'Provínices', 'Localitats'],
      properties: {
        Botiga_id: {
          bsonType: 'objectId'
        },
        Adreça: {
          bsonType: 'string'
        },
        Codi_postal: {
          bsonType: 'int'
        },
        Provínices: {
          bsonType: 'objectId'
        },
        Localitats: {
          bsonType: 'objectId'
        }
      }
    }
  },
  capped:
});

db.createCollection('Comandes', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Comandes',
      required: ['comanda_id', 'Data/Hora', 'Domicili(D) / Botiga (B)', 'Quantitat_begudes', 'Quantitat_hamburgueses', 'Quantitat_pizzes', 'Preu_total', 'Provínices', 'Localitats', 'Productes', 'Clients'],
      properties: {
        comanda_id: {
          bsonType: 'objectId'
        },
        Data / Hora: {
          bsonType: 'date'
        },
        Domicili(D) / Botiga(B): {
          bsonType: 'string'
        },
        Quantitat_begudes: {
          bsonType: 'int'
        },
        Quantitat_hamburgueses: {
          bsonType: 'int'
        },
        Quantitat_pizzes: {
          bsonType: 'int'
        },
        Preu_total: {
          bsonType: 'decimal'
        },
        Lliurament: {
          bsonType: 'date'
        },
        Provínices: {
          bsonType: 'objectId'
        },
        Localitats: {
          bsonType: 'objectId'
        },
        Empleats(repartidor): {
          bsonType: 'objectId'
        },
        Productes: {
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

db.createCollection('Empleats', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Empleats',
      required: ['Empleat_id', 'nom', 'Cognoms', 'NIf', 'Telèfon', 'LLoc_de_treball (C / R)'],
      properties: {
        Empleat_id: {
          bsonType: 'objectId'
        },
        nom: {
          bsonType: 'string'
        },
        Cognoms: {
          bsonType: 'string'
        },
        NIf: {
          bsonType: 'string'
        },
        Telèfon: {
          bsonType: 'int'
        },
        LLoc_de_treball(C / R): {
          bsonType: 'string'
        }
      }
    }
  },
  capped:
});

db.createCollection('Productes', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Productes',
      required: ['producte_id', 'nom', 'Descripció', 'Imatge', 'Preu'],
      properties: {
        producte_id: {
          bsonType: 'objectId'
        },
        nom: {
          bsonType: 'string'
        },
        Descripció: {
          bsonType: 'string'
        },
        Imatge: {
          bsonType: 'string'
        },
        Preu: {
          bsonType: 'decimal'
        },
        Categoria_pizzes: {
          bsonType: 'objectId'
        }
      }
    }
  },
  capped:
});

db.createCollection('Categoria_pizzes', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Categoria_pizzes',
      required: ['categoria_id', 'nom'],
      properties: {
        categoria_id: {
          bsonType: 'objectId'
        },
        nom: {
          bsonType: 'string'
        }
      }
    }
  },
  capped:
});
