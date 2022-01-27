import { Definition } from "./definition.model";

export interface Meaning {
    partOfSpeech: string;
    definitions: Array<Definition>;
}