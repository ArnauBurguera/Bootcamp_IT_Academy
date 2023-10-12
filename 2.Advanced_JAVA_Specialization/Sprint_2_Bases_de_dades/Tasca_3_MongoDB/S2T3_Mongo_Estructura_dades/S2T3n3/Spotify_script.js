db.createCollection('Pagament', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Pagament',
      required: ['pagament_id', 'data_pagamnet', 'numero_ordre', 'total', 'Subscripcions'],
      properties: {
        pagament_id: {
          bsonType: 'objectId'
        },
        data_pagamnet: {
          bsonType: 'date'
        },
        numero_ordre: {
          bsonType: 'int'
        },
        total: {
          bsonType: 'decimal'
        },
        Paypal: {
          bsonType: 'objectId'
        },
        crèdit: {
          bsonType: 'objectId'
        },
        Subscripcions: {
          bsonType: 'objectId'
        }
      }
    }
  },
  capped:
});

db.createCollection('Paypal', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Paypal',
      required: ['paypal_id', 'nom_usuari'],
      properties: {
        paypal_id: {
          bsonType: 'objectId'
        },
        nom_usuari: {
          bsonType: 'string'
        }
      }
    }
  },
  capped:
});

db.createCollection('Subscripcions', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Subscripcions',
      required: ['subscripció_id', 'data_inici_sub', 'data_renovació', 'mètode_pagament', 'Usuari'],
      properties: {
        subscripció_id: {
          bsonType: 'objectId'
        },
        data_inici_sub: {
          bsonType: 'date'
        },
        data_renovació: {
          bsonType: 'date'
        },
        mètode_pagament: {
          bsonType: 'string'
        },
        Usuari: {
          bsonType: 'objectId'
        }
      }
    }
  },
  capped:
});

db.createCollection('crèdit', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'crèdit',
      required: ['data_caduciat', 'codi_seguretat'],
      properties: {
        data_caduciat: {
          bsonType: 'date'
        },
        codi_seguretat: {
          bsonType: 'int'
        }
      }
    }
  },
  capped:
});

db.createCollection('Playlists', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Playlists',
      required: ['playlist_id', 'títol_playlist', 'nombre_cançons', 'data_creació', 'playlist_eliminada', 'Usuari'],
      properties: {
        playlist_id: {
          bsonType: 'objectId'
        },
        títol_playlist: {
          bsonType: 'string'
        },
        nombre_cançons: {
          bsonType: 'int'
        },
        data_creació: {
          bsonType: 'date'
        },
        playlist_eliminada: {
          bsonType: 'string'
        },
        data_eliminació: {
          bsonType: 'date'
        },
        Usuari: {
          bsonType: 'objectId'
        }
      }
    }
  },
  capped:
});

db.createCollection('Usuari', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Usuari',
      required: ['usuari_id', 'email', 'password', 'nom', 'data_naixement', 'sexe', 'país', 'codi_postal', 'Subscripcions'],
      properties: {
        usuari_id: {
          bsonType: 'objectId'
        },
        email: {
          bsonType: 'string'
        },
        password: {
          bsonType: 'string'
        },
        nom: {
          bsonType: 'string'
        },
        data_naixement: {
          bsonType: 'date'
        },
        sexe: {
          bsonType: 'string'
        },
        país: {
          bsonType: 'string'
        },
        codi_postal: {
          bsonType: 'int'
        },
        Subscripcions: {
          bsonType: 'objectId'
        }
      }
    }
  },
  capped:
});

db.createCollection('Seguiment_Artistes', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Seguiment_Artistes',
      required: ['seguiment_artista_id', 'Usuari', 'Artista'],
      properties: {
        seguiment_artista_id: {
          bsonType: 'objectId'
        },
        Usuari: {
          bsonType: 'objectId'
        },
        Artista: {
          bsonType: 'objectId'
        }
      }
    }
  },
  capped:
});

db.createCollection('Àlbums_preferits', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Àlbums_preferits',
      required: ['àlbum_preferit_id', 'Usuari', 'Àlbum'],
      properties: {
        àlbum_preferit_id: {
          bsonType: 'objectId'
        },
        Usuari: {
          bsonType: 'objectId'
        },
        Àlbum: {
          bsonType: 'objectId'
        }
      }
    }
  },
  capped:
});

db.createCollection('Cançó_afegida', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Cançó_afegida',
      required: ['cançó_afegida_id', 'data_addició', 'Usuari', 'Cançó'],
      properties: {
        cançó_afegida_id: {
          bsonType: 'objectId'
        },
        data_addició: {
          bsonType: 'date'
        },
        Usuari: {
          bsonType: 'objectId'
        },
        Cançó: {
          bsonType: 'objectId'
        }
      }
    }
  },
  capped:
});

db.createCollection('Cançons_preferides', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Cançons_preferides',
      required: ['cançó_preferida_id', 'Usuari', 'Cançó'],
      properties: {
        cançó_preferida_id: {
          bsonType: 'objectId'
        },
        Usuari: {
          bsonType: 'objectId'
        },
        Cançó: {
          bsonType: 'objectId'
        }
      }
    }
  },
  capped:
});

db.createCollection('Cançó', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Cançó',
      required: ['cançó_id', 'títol_cançó', 'durada', 'reproduccions', 'Àlbum'],
      properties: {
        cançó_id: {
          bsonType: 'objectId'
        },
        títol_cançó: {
          bsonType: 'string'
        },
        durada: {
          bsonType: 'int'
        },
        reproduccions: {
          bsonType: 'int'
        },
        Àlbum: {
          bsonType: 'objectId'
        }
      }
    }
  },
  capped:
});

db.createCollection('Artista', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Artista',
      required: ['artista_id', 'nom', 'imatge_artista', 'Gènere'],
      properties: {
        artista_id: {
          bsonType: 'objectId'
        },
        nom: {
          bsonType: 'string'
        },
        imatge_artista: {
          bsonType: 'string'
        },
        Gènere: {
          bsonType: 'objectId'
        }
      }
    }
  },
  capped:
});

db.createCollection('Gènere', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Gènere',
      required: ['gènere_id', 'nom_gènere'],
      properties: {
        gènere_id: {
          bsonType: 'objectId'
        },
        nom_gènere: {
          bsonType: 'string'
        }
      }
    }
  },
  capped:
});

db.createCollection('Àlbum', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Àlbum',
      required: ['àlbum_id', 'títol_àlbum', 'any_publicació', 'Artista'],
      properties: {
        àlbum_id: {
          bsonType: 'objectId'
        },
        títol_àlbum: {
          bsonType: 'string'
        },
        any_publicació: {
          bsonType: 'date'
        },
        Artista: {
          bsonType: 'objectId'
        }
      }
    }
  },
  capped:
});
