export class Mood {
  id?: number;
  name?: string;

  public toString = () => {
    return `Mood {id: ${this.id}, name: ${this.name}}`;
  };
}
