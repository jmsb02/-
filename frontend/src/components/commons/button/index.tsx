import { MouseEventHandler } from "react";
import style from "./index.module.css";

type ButtonProps = {
  type?: "submit" | "reset" | "button";
  styled?: "default" | "danger";
  name: string;
  onClick?: MouseEventHandler<HTMLButtonElement>;
};

export default function Button({
  type = "button",
  styled = "default",
  name,
  onClick,
}: ButtonProps) {
  return (
    <button
      type={type}
      className={`${style.btn} ${styled !== "default" && style.danger}`}
      onClick={onClick}
    >
      {name}
    </button>
  );
}
