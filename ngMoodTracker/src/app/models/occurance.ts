import { Mood } from "./mood";

export class Occurance {

    private id: number;
    private mood: Mood;
    private createdAt: Date;

    constructor(id: number, mood: Mood, createdAt: Date) {
        this.id = id;
        this.mood = mood;
        this.createdAt = createdAt;
    }

}
