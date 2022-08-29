export class Endpoints {
  private static basepath = "/fitnesstracker/api/v1/";

  static movements = Endpoints.basepath + "movements";
  static musclegroups = Endpoints.movements + "/musclegroups";
  static workouttemplates = Endpoints.basepath + "workouttemplates";
  static workouttypes = Endpoints.workouttemplates + "/workouttypes";

  private static endpointWorkout = Endpoints.basepath + "workout/";
  static convertTemplate = Endpoints.endpointWorkout + "converttemplate";
  static saveLocally = Endpoints.endpointWorkout + "save";
  static retrieveLocalWorkout = Endpoints.endpointWorkout + "retrieve";
  static persistWorkout = Endpoints.endpointWorkout + "finish";
}
