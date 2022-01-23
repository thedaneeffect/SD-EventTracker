import { Mood } from "./mood";

export class Occurance {
    id?: number;
    mood?: Mood;
    createdAt?: Date;
    happenedAt?: Date;
    description?: string;
}
