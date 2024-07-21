export const environment = {
  production: false,
  apiUrl: 'http://localhost:8080/api',
  qcSection: {
    maxRecords: 30,
    fields: {
      FLG: { type: 'number' },
      DESC: { type: 'text', maxLength: 200, readOnly: true },
      OPUSVAL: { type: 'text', maxLength: 5000, readOnly: true },
      CI: { type: 'radio', initialValue: 'N' },
      SCAN_DATE: { type: 'date' },
      INS_DT: { type: 'date' },
      FLG1: { type: 'number' },
      MIS_USER: { type: 'text', maxLength: 50, hidden: true }
    }
  }
};

export const environmentProd = {
  production: true,
  apiUrl: 'http://api.productionserver.com/api',
  qcSection: {
    maxRecords: 30,
    fields: {
      FLG: { type: 'number' },
      DESC: { type: 'text', maxLength: 200, readOnly: true },
      OPUSVAL: { type: 'text', maxLength: 5000, readOnly: true },
      CI: { type: 'radio', initialValue: 'N' },
      SCAN_DATE: { type: 'date' },
      INS_DT: { type: 'date' },
      FLG1: { type: 'number' },
      MIS_USER: { type: 'text', maxLength: 50, hidden: true }
    }
  }
};