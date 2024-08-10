export class Equipment {
    equipementId: number; // ID should be a number in TypeScript
    name: string;
    UrlImg: string;
    description: string;
    statut: EquipmentStatut; // Enum type
  
    // Optionally, you might want to include relationships as well
    tickets?: Ticket[]; // List of tickets, make sure to define Ticket and EquipmentStatut
  
    constructor(
      equipementId: number,
      name: string,
      UrlImg: string,
      description: string,
      statut: EquipmentStatut,
      tickets?: Ticket[]
    ) {
      this.equipementId = equipementId;
      this.name = name;
      this.UrlImg = UrlImg;
      this.description = description;
      this.statut = statut;
      this.tickets = tickets;
    }
  }
  
  // Assuming you have these enums and classes defined elsewhere
  export enum EquipmentStatut {
    ACTIVE = 'ACTIVE',
    INACTIVE = 'INACTIVE',
    UNDER_REPAIR = 'UNDER_REPAIR'
  }
  
  export class Ticket {
    // Define the properties of the Ticket class here
  }
  