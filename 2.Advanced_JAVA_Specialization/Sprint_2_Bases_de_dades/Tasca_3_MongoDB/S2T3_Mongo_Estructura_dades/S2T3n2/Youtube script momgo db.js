db.createCollection('Etiquetes', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Etiquetes',
      required: ['etiqueta_id', 'nom', 'Videos'],
      properties: {
        etiqueta_id: {
          bsonType: 'objectId'
        },
        nom: {
          bsonType: 'string'
        },
        Videos: {
          bsonType: 'objectId'
        }
      }
    }
  },
  capped:
});

db.createCollection('Videos', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Videos',
      required: ['video_id', 'títol', 'descripció', 'garndària', 'nom_arxiu_video', 'durada', 'thumbnail', 'reproduccions', 'nombre_likes', 'nombre_dislikes', 'estat', 'data_publicació', 'Usuari'],
      properties: {
        video_id: {
          bsonType: 'objectId'
        },
        títol: {
          bsonType: 'string'
        },
        descripció: {
          bsonType: 'string'
        },
        garndària: {
          bsonType: 'int'
        },
        nom_arxiu_video: {
          bsonType: 'string'
        },
        durada: {
          bsonType: 'int'
        },
        thumbnail: {
          bsonType: 'string'
        },
        reproduccions: {
          bsonType: 'string'
        },
        nombre_likes: {
          bsonType: 'int'
        },
        nombre_dislikes: {
          bsonType: 'int'
        },
        estat: {
          bsonType: 'string'
        },
        data_publicació: {
          bsonType: 'date'
        },
        Playlists: {
          bsonType: 'objectId'
        },
        Usuari: {
          bsonType: 'objectId'
        }
      }
    }
  },
  capped:
});

db.createCollection('Dislikes', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Dislikes',
      required: ['dislike_id', 'data_dislike', 'Videos', 'Usuari'],
      properties: {
        dislike_id: {
          bsonType: 'objectId'
        },
        data_dislike: {
          bsonType: 'date'
        },
        Videos: {
          bsonType: 'objectId'
        },
        Usuari: {
          bsonType: 'objectId'
        }
      }
    }
  },
  capped:
});

db.createCollection('Likes', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Likes',
      required: ['like_id', 'data_like', 'Videos', 'Usuari'],
      properties: {
        like_id: {
          bsonType: 'objectId'
        },
        data_like: {
          bsonType: 'date'
        },
        Videos: {
          bsonType: 'objectId'
        },
        Usuari: {
          bsonType: 'objectId'
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
      required: ['playlist_id', 'nom', 'data_creació', 'estat', 'Usuari'],
      properties: {
        playlist_id: {
          bsonType: 'objectId'
        },
        nom: {
          bsonType: 'string'
        },
        data_creació: {
          bsonType: 'date'
        },
        estat: {
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

db.createCollection('Comentari_likes', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Comentari_likes',
      required: ['comentari_like_id', 'data_like_comentari', 'Usuari', 'Comentaris'],
      properties: {
        comentari_like_id: {
          bsonType: 'objectId'
        },
        data_like_comentari: {
          bsonType: 'date'
        },
        Usuari: {
          bsonType: 'objectId'
        },
        Comentaris: {
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
      required: ['usuari_id', 'email', 'password', 'nom', 'data_naixement', 'sexe', 'país', 'codi_postal', 'canals'],
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
        canals: {
          bsonType: 'objectId'
        }
      }
    }
  },
  capped:
});

db.createCollection('canals', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'canals',
      required: ['canal_id', 'nom', 'descripció', 'data_creació', 'Usuari'],
      properties: {
        canal_id: {
          bsonType: 'objectId'
        },
        nom: {
          bsonType: 'string'
        },
        descripció: {
          bsonType: 'string'
        },
        data_creació: {
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

db.createCollection('Comentaris', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Comentaris',
      required: ['comentari_id', 'text_comentari', 'data_comentari', 'Usuari'],
      properties: {
        comentari_id: {
          bsonType: 'objectId'
        },
        text_comentari: {
          bsonType: 'string'
        },
        data_comentari: {
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

db.createCollection('Subscripcions', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Subscripcions',
      required: ['subscripcio_id', 'Usuari', 'canals'],
      properties: {
        subscripcio_id: {
          bsonType: 'objectId'
        },
        Usuari: {
          bsonType: 'objectId'
        },
        canals: {
          bsonType: 'objectId'
        }
      }
    }
  },
  capped:
});

db.createCollection('Cometari_dislikes', {
  validator: {
    $jsonSchema: {
      bsonType: 'object',
      title: 'Cometari_dislikes',
      required: ['comentari_dislike_id', 'data_dislike_comentari', 'Usuari', 'Comentaris'],
      properties: {
        comentari_dislike_id: {
          bsonType: 'objectId'
        },
        data_dislike_comentari: {
          bsonType: 'date'
        },
        Usuari: {
          bsonType: 'objectId'
        },
        Comentaris: {
          bsonType: 'objectId'
        }
      }
    }
  },
  capped:
});
